package my.utm.ip.ecofootprint.repository;

import java.util.List;

import my.utm.ip.ecofootprint.model.DAO.WaterDAO;

public interface WaterRepository {

	List<WaterDAO> getAllWater();

	WaterDAO getWaterById(int waterId);

	WaterDAO addWater(WaterDAO dao);

	WaterDAO updateWater(WaterDAO water);
	
	public boolean deleteWater(int waterId);

	int getWaterIdByUserId(int userId);
	
}
