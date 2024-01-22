package my.utm.ip.ecofootprint.repositoryJDBCImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import my.utm.ip.ecofootprint.model.DAO.WaterDAO;
import my.utm.ip.ecofootprint.repository.WaterRepository;

@Repository
public class WaterRepositoryJDBCImpl implements WaterRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    // Keep an in-memory list of water
    private final List<WaterDAO> waterList = getAllWaterFromDatabase();

    private List<WaterDAO> getAllWaterFromDatabase() {
	    String sql = "SELECT * FROM water";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<WaterDAO>(WaterDAO.class));
    }

    public List<WaterDAO> getAllWater() {
    	return Collections.unmodifiableList(waterList);
	}

	public WaterDAO getWaterById(int waterId) {
        String sql = "SELECT * FROM water WHERE water_id = ?";
        
        try {
        		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(WaterDAO.class), waterId);
	        } catch (Exception e) {
	            return null; //return null if id = 0
	        }
	}

	public WaterDAO addWater(WaterDAO waterDAO) {
		String sql = "INSERT INTO water (WaterNumOfDays, usage_rm, usage_m3, methods, practices, month, prop_factor, bill) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    jdbcTemplate.update(
	    		sql,
	            waterDAO.getWaterNumOfDays(),
	            waterDAO.getWaterUsageRM(),
	            waterDAO.getWaterUsageM3(),
	            waterDAO.getWaterMethods(),
	            waterDAO.getWaterPractices(),
	            waterDAO.getWaterMonth(),
	            waterDAO.getWaterPropFactor(),
	            waterDAO.getWaterBill()
	        );

	        // Refresh after add new data
	        return getWaterById(waterDAO.getWaterId());
	}

	public WaterDAO updateWater(WaterDAO waterDAO) {
	    String sql = "UPDATE water SET WaterNumOfDays=?, usage_rm=?, usage_m3=?, methods=?, " +
	            "practices=?, month=?, prop_factor=?, bill=?, carbon_result=? WHERE water_id=?";
	    jdbcTemplate.update(
	            sql,
	            waterDAO.getWaterNumOfDays(),
	            waterDAO.getWaterUsageRM(),
	            waterDAO.getWaterUsageM3(),
	            waterDAO.getWaterMethods(),
	            waterDAO.getWaterPractices(),
	            waterDAO.getWaterMonth(),
	            waterDAO.getWaterPropFactor(),
	            waterDAO.getWaterBill(),
	            waterDAO.getCarbonResult(),
	            waterDAO.getWaterId()
	    );

	    // Refresh after update
	    return getWaterById(waterDAO.getWaterId());
	}

	public boolean deleteWater(int waterId) {
		String sql = "DELETE FROM water WHERE water_id=?";
		int affectedRows = jdbcTemplate.update(sql, waterId);

		// Refresh the in-memory list after deleting the record
		if (affectedRows > 0) {
			refreshInMemoryList();
			return true;
		}

	        return false;
	}
	
	private void refreshInMemoryList() {
		waterList.clear();
	    waterList.addAll(getAllWaterFromDatabase());
	}
	    
	public List<WaterDAO> getWaterByUserIdAndMonth(int userId, String month) {
		String sql = "SELECT * FROM water WHERE user_id = ? AND month = ?";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(WaterDAO.class), userId, month);
	}
	
	public int getWaterIdByUserId(int userId) {
		String sql = "SELECT waterId FROM water WHERE userId = ?";
		try {
			return jdbcTemplate.queryForObject(sql, Integer.class, userId);
		} catch (Exception e) {
			return 0; // or handle the exception as needed
		}
	}
	
}
