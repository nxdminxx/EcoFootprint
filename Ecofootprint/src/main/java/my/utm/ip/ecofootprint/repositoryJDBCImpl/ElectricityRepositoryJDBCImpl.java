package my.utm.ip.ecofootprint.repositoryJDBCImpl;

import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import my.utm.ip.ecofootprint.model.DAO.ElectricityDAO;
import my.utm.ip.ecofootprint.repository.ElectricityRepository;

public class ElectricityRepositoryJDBCImpl implements ElectricityRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    // Keep an in-memory list of water
    private final List<ElectricityDAO> electricityList= getAllElectricityFromDatabase();

    private List<ElectricityDAO> getAllElectricityFromDatabase() {
	    String sql = "SELECT * FROM electricity";
	    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ElectricityDAO.class));
    }

    public List<ElectricityDAO> getAllElectricity() {
    	return Collections.unmodifiableList(electricityList);
	}

	public ElectricityDAO getElectricityById(int electricityId) {
        String sql = "SELECT * FROM electricity WHERE electricityId = ?";
        
        try {
        		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(ElectricityDAO.class), electricityId);
	        } catch (Exception e) {
	            return null; //return null if id = 0
	        }
	}

	public ElectricityDAO addElectricity(ElectricityDAO electricityDAO) {
		String sql = "INSERT INTO electricity (ElectricityNumOfDays, electricityUsageRM, electricityUsageKHW, electricityMethods, electricityPractices, electricityMonth, electricitPropFactor, electricityBill) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    jdbcTemplate.update(
	    		sql,
	            electricityDAO.getElectricityNumOfDays(),
	            electricityDAO.getElectricityUsageRM(),
	            electricityDAO.getElectricityUsageKWH(),
	            electricityDAO.getElectrictiyMethods(),
	            electricityDAO.getElectricityPractices(),
	            electricityDAO.getElectricityMonth(),
	            electricityDAO.getElectricityPropFactor(),
	            electricityDAO.getElectricityBill()
	        );

	        // Refresh after add new data
	        return getElectricityById(electricityDAO.getElectricityId());
	}

	public ElectricityDAO updateElectricity(ElectricityDAO electricityDAO) {
	    String sql = "UPDATE electricity SET electricityNumOfDays=?, electricityUsageRM=?, electricityUsageKWH=?, electricityMethods=?, " +
	            "electricityPractices=?, electricityMonth=?, electricityPropFactor=?, electricityBill=?, carbonResult=? WHERE electricityId=?";
	    jdbcTemplate.update(
	            sql,
	            electricityDAO.getElectricityNumOfDays(),
	            electricityDAO.getElectricityUsageRM(),
	            electricityDAO.getElectricityUsageKWH(),
	            electricityDAO.getElectrictiyMethods(),
	            electricityDAO.getElectricityPractices(),
	            electricityDAO.getElectricityMonth(),
	            electricityDAO.getElectricityPropFactor(),
	            electricityDAO.getElectricityBill(),
	            electricityDAO.getCarbonResult()
	    );

	    // Refresh after update
	    return getElectricityById(electricityDAO.getElectricityId());
	}

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
	    
	public int getElectricityIdByUserId(int userId) {
		String sql = "SELECT recycleId FROM recycle WHERE userId = ?";
		try {
			return jdbcTemplate.queryForObject(sql, Integer.class, userId);
		} catch (Exception e) {
			return 0; // or handle the exception as needed
		}
	}

}
