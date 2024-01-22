package my.utm.ip.ecofootprint.Service;

import java.util.List;

import my.utm.ip.ecofootprint.model.Electricity;
import my.utm.ip.ecofootprint.model.DAO.ElectricityDAO;

public interface ElectricityService {

	List<Electricity> getAllElectricity();

	Electricity getElectricityById(int electricityId);

	Electricity addElectricity(final Electricity electricityDAO);

	Electricity updateElectricity(final Electricity electricityDAO);

	public boolean deleteElectricity(int electricityId);

    double calculateElectricity(int electricityId);

	int getElectricityIdByUserId(int userId);
	
}
