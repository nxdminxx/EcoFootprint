package my.utm.ip.ecofootprint.Service;

import java.util.List;

import my.utm.ip.ecofootprint.model.Water;
import my.utm.ip.ecofootprint.model.DAO.WaterDAO;

public interface WaterService {

	List<Water> getAllWater();

	Water getWaterById(int waterId);

	Water addWater(Water waterDAO);

	Water updateWater(Water waterDAO);

    boolean deleteWater(int waterId);

    double calculateWater(int waterId);

    int getWaterIdByUserId(int userId);
    
}
