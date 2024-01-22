package my.utm.ip.ecofootprint.ServiceDatabaseImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.utm.ip.ecofootprint.Service.ElectricityService;
import my.utm.ip.ecofootprint.model.Electricity;
import my.utm.ip.ecofootprint.model.DAO.ElectricityDAO;
import my.utm.ip.ecofootprint.repository.ElectricityRepository;

public class ElectricityServiceDatabaseImpl implements ElectricityService {

	@Autowired
	private ElectricityRepository repo;

	@Override
	public List<Electricity> getAllElectricity() {
		List<ElectricityDAO> dao = repo.getAllElectricity();
		return new ELectricity(dao);
	}

	// get data form db to view
	@Override
	public Electricity getElectricityById(int electricityId) {
		ElectricityDAO dao = repo.getElectricityById(electricityId);
		return new Electricity(dao);
	}

	// pass data from view to db
	// convert DTO -> DAO
	@Override
	public Electricity addElectricity(Electricity electricity) {
		ElectricityDAO dao = electricity.toDAO();
		dao = repo.addElectricity(dao);
		return new Electricity(dao);
	}

	@Override
	public Electricity updateElectricity(Electricity electricity) {
		ElectricityDAO dao = electricity.toDAO();
		dao = repo.updateElectricity(dao);
		return new Electricity(dao); // electricity
	}

	@Override
	public boolean deleteElectricity(int electricityId) {
		return repo.deleteElectricity(electricityId);
	}

	public double calculateElectricity(int electricityId) {
		ElectricityDAO dao = repo.getElectricityById(electricityId);

		if (dao != null)
			return 0.0;

		Electricity electricity = new Electricity(dao);
		// Implement the calculation logic based on the provided formula
		double carbonFootprint = (electricity.getElectricityUsageKWH() * electricity.getElectricityPropFactor() * 0.2)
				* electricity.getElectrictyNumOfDays();

		// Set the carbon footprint result in the Water object
		electricity.setCarbonResult(carbonFootprint);

		// Update the water record in the database with the new carbon footprint result
		repo.updateElectricity(electricity.toDAO());
		return carbonFootprint;
	}

	@Override
	public int getElectricityIdByUserId(int userId) {
		return repo.getElectricityIdByUserId(userId);
	}

}
