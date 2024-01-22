package my.utm.ip.ecofootprint.repositoryJDBCImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import my.utm.ip.ecofootprint.model.DAO.RecycleDAO;
import my.utm.ip.ecofootprint.repository.RecycleRepository;

public class RecycleRepositoryJDBCImpl implements RecycleRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    // Keep an in-memory list of water
    private final List<RecycleDAO> recycleList = getAllRecycleFromDatabase();

    private List<RecycleDAO> getAllRecycleFromDatabase() {
	    String sql = "SELECT * FROM recycle";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RecycleDAO.class));
    }

    public List<RecycleDAO> getAllRecycle() {
    	return Collections.unmodifiableList(recycleList);
	}

	public RecycleDAO getRecycleById(int recycleId) {
        String sql = "SELECT * FROM recycle WHERE recycleId = ?";
        
        try {
        		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(RecycleDAO.class), recycleId);
	        } catch (Exception e) {
	            return null; //return null if id = 0
	        }
	}

	public RecycleDAO addRecycle(RecycleDAO recycleDAO) {
		String sql = "INSERT INTO recycle (recycleStartDate, recycleEndDate, recycleType, recycleTotalInKG,\r\n"
				+ "                recycleDescribeMethod, recycleHabits, recycelAccumulatedTotalInRM, recycleChallengePractice,\r\n"
				+ "                recycleProof) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    jdbcTemplate.update(
	    		sql,
	    		recycleDAO.getRecycleStartDate(),
	    		recycleDAO.getRecycleEndDate(),
	    		recycleDAO.getRecycleType(),
	    		recycleDAO.getRecycleTotalInKG(),
	    		recycleDAO.getRecycleDescribeMethod(),
	    		recycleDAO.getRecycleHabits(),
	    		recycleDAO.getRecycelAccumulatedTotalInRM(),
	    		recycleDAO.getRecycleChallengePractice(),
	    		recycleDAO.getRecycleProof()
	        );
	        // Refresh after add new data
	        return getRecycleById(recycleDAO.getRecycleId());
	}

	public RecycleDAO updateRecycle(RecycleDAO recycleDAO) {
	    String sql = "UPDATE recycle SET recycleStartDate=?, recycleEndDate=?, recycleType=?, recycleTotalInKG=?, " +
	            "recycleDescribeMethod=?, recycleHabits=?, recycelAccumulatedTotalInRM=?, recycleChallengePractice=?, recycleProof=? WHERE recycleId=?";
	    jdbcTemplate.update(
	            sql,
	            recycleDAO.getRecycleStartDate(),
	    		recycleDAO.getRecycleEndDate(),
	    		recycleDAO.getRecycleType(),
	    		recycleDAO.getRecycleTotalInKG(),
	    		recycleDAO.getRecycleDescribeMethod(),
	    		recycleDAO.getRecycleHabits(),
	    		recycleDAO.getRecycelAccumulatedTotalInRM(),
	    		recycleDAO.getRecycleChallengePractice(),
	    		recycleDAO.getRecycleProof(),
	    		recycleDAO.getRecycleId()
	    );

	    // Refresh after update
	    return getRecycleById(recycleDAO.getRecycleId());
	}


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
	        recycleList.addAll(getAllRecycle());
	    }
	    
	    public List<RecycleDAO> getRecycleByUserIdAndMonth(int userId, String month) {
	        String sql = "SELECT * FROM recycle WHERE user_id = ? AND month = ?";
	        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RecycleDAO.class), userId, month);
	    }
	    
}
