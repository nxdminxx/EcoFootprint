package my.ip.ecofootprint.service;

import java.util.List;

import my.ip.ecofootprint.DAO.ElectricityDAO;
import my.ip.ecofootprint.model.Electricity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

public class ElectricityService{

	
	 @Autowired
	 private ElectricityDAO electricityRepository;
	 
	 public List<Electricity> getAllElectricity() {
	        return electricityRepository.getAllElectricity();
	    }

	 public Electricity getElectricityById(int electricityId) {
		 return electricityRepository.getElectricityById(electricityId);
	 }
	 
	 public Electricity addElectricity(Electricity electricity) {
		 return electricityRepository.addElectricity(electricity);
	 }
	 
	 public Electricity updateElectricity(Electricity electricity) {
		 return electricityRepository.updateElectricity(electricity);
	 }

	 public boolean deleteElectricity(int electricityId) {
		 return electricityRepository.deleteElectricity(electricityId);
	    }
	    
	 public double calculateElectricity(int electricityId) {
		 Electricity electricity = electricityRepository.getElectricityById(electricityId);

		 if (electricity != null) {
			 // Implement the calculation logic based on the provided formula
			 double carbonFootprint = (electricity.getElectricityUsageKWH() * electricity.getElectricityPropFactor() * 0.2) * electricity.getElectrictyNumOfDays();

	         // Set the carbon footprint result in the Water object
			 electricity.setCarbonResult(carbonFootprint);

	         // Update the water record in the database with the new carbon footprint result
	         electricityRepository.updateElectricity(electricity);
	         return carbonFootprint;
	    }

	        // Return 0 if the water object with the specified ID is not found
	        return 0;
	    }
}
