package my.ip.ecofootprint.service;

import my.ip.ecofootprint.model.Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WaterServiceImpl implements WaterService {

	@Autowired
    private JdbcTemplate jdbcTemplate;  //dalam file config.java
	
	// Simulate a water table with internal memory
    private final List<Water> waterList = new ArrayList<>();

    // Create memory data to simulate the Water table
    public WaterServiceImpl() {
        insertWater(30, 100.0, 50.0, "Once a week", "Turn off the tap while brushing", "January 2024", 2L, new byte[]{});
        insertWater(28, 90.0, 45.0, "Twice a week", "Use a low-flow showerhead", "February 2024", 1L, new byte[]{});
        // Add more sample data as needed
    }
    
    private void insertWater(int numOfDays, double usageRM, double usageM3, String methods,
            String practices, String month, long propFactor, byte[] bill) {
	Water water = new Water(0, numOfDays, usageRM, usageM3, methods, practices, month, propFactor, bill);
	
	if (waterList.isEmpty()) {
	water.setWaterId(1);
	} else {
	int lastWaterId = waterList.get(waterList.size() - 1).getWaterId();
	water.setWaterId(lastWaterId + 1);
	}
	
	waterList.add(water);
	}

    
    private void insertWaterIntoDatabase(Water water) {
        String sql = "INSERT INTO water (waterId, WaterNumOfDays, usage_rm, usage_m3, methods, practices, month, prop_factor, bill) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                
                water.getWaterId(),
                water.getWaterNumOfDays(),
                water.getWaterUsageRM(),
                water.getWaterUsageM3(),
                water.getWaterMethods(),
                water.getWaterPractices(),
                water.getWaterMonth(),
                water.getWaterPropFactor(),
                water.getWaterBill()
        );
    }

    @Override
    public Water addWater(Water water) {
        if (waterList.isEmpty()) {
            water.setWaterId(1);
        } else {
            int lastWaterId = waterList.get(waterList.size() - 1).getWaterId();
            water.setWaterId(lastWaterId + 1);
        }

        if (getWaterById(water.getWaterId()) == null) {
            waterList.add(water);
            // Insert into database
            insertWaterIntoDatabase(water);
            return water;
        }

        return null;
    }

    // Method to fetch all water records from the database
    private List<Water> getAllWaterFromDatabase() {
        String sql = "SELECT * FROM water";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Water.class));
    }
    
    @Override
    public List<Water> getAllWater() {
        // Fetch all water records from the database
        return Collections.unmodifiableList(getAllWaterFromDatabase());
    }
     
    // Method to update a water record in the database
    private void updateWaterInDatabase(Water water) {
        String sql = "UPDATE water SET num_of_days=?, usage_rm=?, usage_m3=?, methods=?, " +
                "practices=?, month=?, prop_factor=?, bill=? WHERE water_id=?";
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
                water.getWaterId()
        );
    }

    @Override
    public Water updateWater(Water water) {
        // Update the water record in the database
        updateWaterInDatabase(water);

        // Update the water record in the in-memory list (if present)
        Water found = getWaterById(water.getWaterId());
        if (found != null) {
            found.assign(water);
            return found;
        }

        return null;
    }

    // Method to delete a water record from the database based on waterId
    private void deleteWaterFromDatabase(int waterId) {
        String sql = "DELETE FROM water WHERE water_id=?";
        jdbcTemplate.update(sql, waterId);
    }

    
    @Override
    public boolean deleteWater(int waterId) {
        // Delete the water record from the database
        deleteWaterFromDatabase(waterId);

        // Remove the water record from the in-memory list (if present)
        Water found = getWaterById(waterId);
        if (found != null) {
            waterList.remove(found);
            return true;
        }

        return false;
    }
    
    @Override
    public Water getWaterById(int waterId) {
        for (Water water : waterList) {
            if (water.getWaterId() == waterId)
                return water;
        }
        return null;
    }

    @Override
    public double calculateWater(int waterId) {
        Water water = getWaterById(waterId);

        if (water != null) {
            // Implement your calculation logic based on the properties of the Water object
            // For example, calculate total water consumption by adding usageRM and usageM3
            return water.getWaterUsageRM() + water.getWaterUsageM3();
        }

        // Return 0 if the water object with the specified ID is not found
        return 0;
    }
}