package my.ip.ecofootprint.repository;

import java.util.Collections;
import java.util.List;

import my.ip.ecofootprint.DAO.ElectricityDAO;
import my.ip.ecofootprint.model.Electricity;
import my.ip.ecofootprint.service.Autowired;
import my.ip.ecofootprint.service.BeanPropertyRowMapper;
import my.ip.ecofootprint.service.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ElectricityRepository implements ElectricityDAO {

	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    // Keep an in-memory list of water
	    private final List<Electricity> electricityList= getAllElectricityFromDatabase();

	    private List<Electricity> getAllElectricityFromDatabase() {
		    String sql = "SELECT * FROM electricity";
		    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Electricity.class));
	    }

	    @Override
	    public List<Electricity> getAllElectricity() {
	    	return Collections.unmodifiableList(electricityList);
		}

		@Override
		public Electricity getElectricityById(int electricityId) {
	        String sql = "SELECT * FROM electricity WHERE electricityId = ?";
	        
	        try {
	        		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Electricity.class), electricityId);
		        } catch (Exception e) {
		            return null; //return null if id = 0
		        }
		}

		@Override
		public Electricity addElectricity(Electricity electricity) {
			String sql = "INSERT INTO electricity (ElectricityNumOfDays, electricityUsageRM, electricityUsageKHW, electricityMethods, electricityPractices, electricityMonth, electricitPropFactor, electricityBill) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		    jdbcTemplate.update(
		    		sql,
		            electricity.getElectricityNumOfDays(),
		            electricity.getElectricityUsageRM(),
		            electricity.getElectricityUsageKWH(),
		            electricity.getElectrictiyMethods(),
		            electricity.getElectricityPractices(),
		            electricity.getElectricityMonth(),
		            electricity.getElectricityPropFactor(),
		            electricity.getElectricityBill()
		        );

		        // Refresh after add new data
		        return getElectricityById(electricity.getElectricityId());
		}

		public Electricity updateElectricity(Electricity electricity) {
		    String sql = "UPDATE electricity SET electricityNumOfDays=?, electricityUsageRM=?, electricityUsageKWH=?, electricityMethods=?, " +
		            "electricityPractices=?, electricityMonth=?, electricityPropFactor=?, electricityBill=?, carbonResult=? WHERE electricityId=?";
		    jdbcTemplate.update(
		            sql,
		            electricity.getElectricityNumOfDays(),
		            electricity.getElectricityUsageRM(),
		            electricity.getElectricityUsageKWH(),
		            electricity.getElectrictiyMethods(),
		            electricity.getElectricityPractices(),
		            electricity.getElectricityMonth(),
		            electricity.getElectricityPropFactor(),
		            electricity.getElectricityBill(),
		            electricity.getCarbonResult()
		    );

		    // Refresh after update
		    return getElectricityById(electricity.getElectricityId());
		}

		@Override
		public boolean deleteElectricity(int electricityId) {
			String sql = "DELETE FROM electricity WHERE electricityId=?";
			int affectedRows = jdbcTemplate.update(sql, electricityId);

			// Refresh the in-memory list after deleting the record
			if (affectedRows > 0) {
				refreshInMemoryList();
				return true;
			}

		        return false;
		}
		
		private void refreshInMemoryList() {
			electricityList.clear();
			electricityList.addAll(getAllElectricityFromDatabase());
		}
		    
		public List<Electricity> getElectricityByUserIdAndMonth(int userId, String month) {
			String sql = "SELECT * FROM electricity WHERE ElectricityId = ? AND electricityMonth = ?";
		    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Electricity.class), userId, month);
		}

}
