package my.utm.ip.ecofootprint.ServiceDatabaseImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.ecofootprint.Service.WaterService;
import my.utm.ip.ecofootprint.model.Water;
import my.utm.ip.ecofootprint.model.DAO.WaterDAO;
import my.utm.ip.ecofootprint.repository.WaterRepository;

public class WaterServiceDatabaseImpl implements WaterService {

	@Autowired
	private WaterRepository repo;

	@Override
	public List<Water> getAllWater() {
		WaterDAO dao = repo.getAllWater();
		return new Water(dao);
	}

	// get data form db to view
	@Override
	public Water getWaterById(int waterId) {
		WaterDAO dao = repo.getWaterById(waterId);
		return new Water(dao);
	}

	// pass data from view to db
	// convert DTO -> DAO
	@Override
	public Water addWater(Water water) {
		WaterDAO dao = water.toDAO();
		dao = repo.addWater(dao);
		return new Water(dao);
	}

	@Override
	public Water updateWater(Water water) {
		WaterDAO dao = repo.updateWater(water.toDAO());
		return new Water(dao);
	}

	@Override
	public boolean deleteWater(int waterId) {
		return repo.deleteWater(waterId);
	}

	@Override
	public double calculateWater(int waterId) {
		WaterDAO dao = repo.getWaterById(waterId);

		if (dao != null)
			return 0.0;

		Water water = new Water(dao);
		double carbonFootprint = (water.getWaterUsageM3() * water.getWaterPropFactor() * 0.2)
				* water.getWaterNumOfDays();

		// Set the carbon footprint result in the Water object
		water.setCarbonResult(carbonFootprint);

		// Update the water record in the database with the new carbon footprint result
		repo.updateWater(water.toDAO());
		return carbonFootprint;

	}

	@Override
	public int getWaterIdByUserId(int userId) {
		return repo.getWaterIdByUserId(userId);
	}
}
