package my.ip.ecofootprint.service;

import my.ip.ecofootprint.model.Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class RecycleServiceImpl implements RecycleService {
	
	 @Autowired
    private JdbcTemplate jdbcTemplate;

    // Keep an in-memory list of water
    private final List<Recycle>recycleList = getAllWaterFromDatabase();

    private List<Recycle> getAllWaterFromDatabase() {
	    String sql = "SELECT * FROM recycle";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Recycle.class));
    }

    @Override
    public List<Recycle> getAllWater() {
    	return Collections.unmodifiableList(recycleList);
	}

	@Override
	public Water getRecycleById(int recycleId) {
        String sql = "SELECT * FROM recycle WHERE recycleId = ?";
        
        try {
        		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Recycle.class), recycleId);
	        } catch (Exception e) {
	            return null; //return null if id = 0
	        }
	    }

	@Override
	public Recycle addRecycle(Recycle recycle) {
		String sql = "INSERT INTO recycle (recycleStartDate, recycleEndDate, recycleType, recycleTotalInKG,\r\n"
				+ "                recycleDescribeMethod, recycleHabits, recycelAccumulatedTotalInRM, recycleChallengePractice,\r\n"
				+ "                recycleProof) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    jdbcTemplate.update(
	    		sql,
	    		recycle.getRecycleStartDate(),
	    		recycle.getRecycleEndDate(),
	    		recycle.getRecycleType(),
	    		recycle.getRecycleTotalInKG(),
	    		recycle.getRecycleDescribeMethod(),
	    		recycle.getRecycleHabits(),
	    		recycle.getRecycelAccumulatedTotalInRM(),
	    		recycle.getRecycleChallengePractice(),
	    		recycle.getRecycleProof()
	        );
	        // Refresh after add new data
	        return getRecycleId(recycle.getRecycleId());
	    }

	public Recycle updateRecycle(Recycle recycle) {
	    String sql = "UPDATE recycle SET recycleStartDate=?, recycleEndDate=?, recycleType=?, recycleTotalInKG=?, " +
	            "recycleDescribeMethod=?, recycleHabits=?, recycelAccumulatedTotalInRM=?, recycleChallengePractice=?, recycleProof=? WHERE recycleId=?";
	    jdbcTemplate.update(
	            sql,
	            recycle.getRecycleStartDate(),
	    		recycle.getRecycleEndDate(),
	    		recycle.getRecycleType(),
	    		recycle.getRecycleTotalInKG(),
	    		recycle.getRecycleDescribeMethod(),
	    		recycle.getRecycleHabits(),
	    		recycle.getRecycelAccumulatedTotalInRM(),
	    		recycle.getRecycleChallengePractice(),
	    		recycle.getRecycleProof(),
	    		recycle.getRecycleId()
	    );

	    // Refresh after update
	    return getRecycleId(recycle.getRecycleId());
	}


	@Override
	public boolean deleteRecycle(int recycleId) {
		String sql = "DELETE FROM recycle WHERE recycleId=?";
		int affectedRows = jdbcTemplate.update(sql, recycleId);

		// Refresh the in-memory list after deleting the record
		if (affectedRows > 0) {
			refreshInMemoryList();
			return true;
		}

	        return false;
	    }

	public double calculateRecycle(int recycleId) {
	    Recycle recycle = getRecycleById(recycleId);

	    if (recycle != null) {
	        // Implement the calculation logic based on the provided formula
	        double carbonFootprint = (recycle.getRecycleTotalInKG()* recycle.recycle.getRecycelAccumulatedTotalInRM();

	        // Set the carbon footprint result in the Water object
	        recycle.setCarbonResult(carbonFootprint);

	        // Update the water record in the database with the new carbon footprint result
	        updateRecycle(recycle);

	        return carbonFootprint;
	    }

	    // Return 0 if the water object with the specified ID is not found
	    return 0;
	}
	
	 @Override
	    public int getRecycleIdByUserId(int userId) {
	        String sql = "SELECT recycleId FROM recycle_user_mapping WHERE user_id = ?";
	        try {
	            return jdbcTemplate.queryForObject(sql, Integer.class, userId);
	        } catch (Exception e) {
	            return 0;
	        }
	    }

	    private void refreshInMemoryList() {
	        recycleList.clear();
	        recycleList.addAll(getAllRecycleFromDatabase());
	    }
	    
	    @Override
	    public List<Recycle> getRecycleByUserIdAndMonth(int userId, String month) {
	        String sql = "SELECT * FROM recycle WHERE user_id = ? AND month = ?";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Recycle.class), userId, month);
	    }
}