package my.ip.ecofootprint.service;

import my.ip.ecofootprint.DAO.WaterDAO;
import my.ip.ecofootprint.model.Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WaterService{
	
	 @Autowired
	 private WaterDAO waterRepository;
	 
	 public List<Water> getAllWater() {
	        return waterRepository.getAllWater();
	    }

	 public Water getWaterById(int waterId) {
		 return waterRepository.getWaterById(waterId);
	 }
	 
	 public Water addWater(Water water) {
		 return waterRepository.addWater(water);
	 }
	 
	 public Water updateWater(Water water) {
		 return waterRepository.updateWater(water);
	 }

	 public boolean deleteWater(int waterId) {
		 return waterRepository.deleteWater(waterId);
	    }
	    
	 public double calculateWater(int waterId) {
		 Water water = waterRepository.getWaterById(waterId);

		 if (water != null) {
			 // Implement the calculation logic based on the provided formula
			 double carbonFootprint = (water.getWaterUsageM3() * water.getWaterPropFactor() * 0.2) * water.getWaterNumOfDays();

	         // Set the carbon footprint result in the Water object
			 water.setCarbonResult(carbonFootprint);

	         // Update the water record in the database with the new carbon footprint result
	         waterRepository.updateWater(water);
	         return carbonFootprint;
	    }

	        // Return 0 if the water object with the specified ID is not found
	        return 0;
	    }
}