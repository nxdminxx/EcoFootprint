package my.ip.ecofootprint.DAO;

import java.util.List;

import my.ip.ecofootprint.model.Water;

public interface WaterDAO {

	 List<Water> getAllWater();
	 Water getWaterById(int waterId);
	 Water addWater(Water water);
	 Water updateWater(Water water);
	 public boolean deleteWater(int waterId);
	 
}
