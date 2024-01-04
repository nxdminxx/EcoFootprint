package my.ip.ecofootprint.repository;

import java.util.Collections;
import java.util.List;

import my.ip.ecofootprint.DAO.WaterDAO;
import my.ip.ecofootprint.model.Water;
import my.ip.ecofootprint.service.Autowired;
import my.ip.ecofootprint.service.BeanPropertyRowMapper;
import my.ip.ecofootprint.service.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class WaterRepository implements WaterDAO {

	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    // Keep an in-memory list of water
	    private final List<Water> waterList = getAllWaterFromDatabase();

	    private List<Water> getAllWaterFromDatabase() {
		    String sql = "SELECT * FROM water";
		    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Water.class));
	    }

	    @Override
	    public List<Water> getAllWater() {
	    	return Collections.unmodifiableList(waterList);
		}

		@Override
		public Water getWaterById(int waterId) {
	        String sql = "SELECT * FROM water WHERE water_id = ?";
	        
	        try {
	        		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Water.class), waterId);
		        } catch (Exception e) {
		            return null; //return null if id = 0
		        }
		}

		@Override
		public Water addWater(Water water) {
			String sql = "INSERT INTO water (WaterNumOfDays, usage_rm, usage_m3, methods, practices, month, prop_factor, bill) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		    jdbcTemplate.update(
		    		sql,
		            water.getWaterNumOfDays(),
		            water.getWaterUsageRM(),
		            water.getWaterUsageM3(),
		            water.getWaterMethods(),
		            water.getWaterPractices(),
		            water.getWaterMonth(),
		            water.getWaterPropFactor(),
		            water.getWaterBill()
		        );

		        // Refresh after add new data
		        return getWaterById(water.getWaterId());
		}

		public Water updateWater(Water water) {
		    String sql = "UPDATE water SET WaterNumOfDays=?, usage_rm=?, usage_m3=?, methods=?, " +
		            "practices=?, month=?, prop_factor=?, bill=?, carbon_result=? WHERE water_id=?";
		    jdbcTemplate.update(
		            sql,
		            water.getWaterNumOfDays(),
		            water.getWaterUsageRM(),
		            water.getWaterUsageM3(),
		            water.getWaterMethods(),
		            water.getWaterPractices(),
		            water.getWaterMonth(),
		            water.getWaterPropFactor(),
		            water.getWaterBill(),
		            water.getCarbonResult(),
		            water.getWaterId()
		    );

		    // Refresh after update
		    return getWaterById(water.getWaterId());
		}

		@Override
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
		    
		public List<Water> getWaterByUserIdAndMonth(int userId, String month) {
			String sql = "SELECT * FROM water WHERE user_id = ? AND month = ?";
		    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Water.class), userId, month);
		}

}
