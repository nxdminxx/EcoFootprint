package my.ip.ecofootprint.service;

import java.util.List;

import my.ip.ecofootprint.model.Water;

public interface WaterService {

	 List<Water> getAllWater();
	 Water getWaterById(int waterId);
	 Water addWater(Water water);
	 Water updateWater(Water water);
	 public boolean deleteWater(int waterId);
	 double calculateWater(int waterId);
	 
}
