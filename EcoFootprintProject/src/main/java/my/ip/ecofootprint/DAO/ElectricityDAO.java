package my.ip.ecofootprint.DAO;

import my.ip.ecofootprint.model.Electricity;

import java.util.List;

public interface ElectricityDAO {
	
	 List<Electricity> getAllElectricity();
	 Electricity getElectricityById(int electricityId);
	 Electricity addElectricity(Electricity electricity);
	 Electricity updateElectricity(Electricity electricity);
	 public boolean deleteElectricity(int electricityId);
	 
}
