package my.ip.ecofootprint.service;

import my.ip.ecofootprint.model.Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WaterServiceImpl implements WaterService {

	// Simulate a water table with internal memory
    private final List<Water> waterList = new ArrayList<>();

    // Create memory data to simulate the Water table
    public WaterServiceImpl() {
        insertWater(30, 100.0, 50.0, "Once a week", "Turn off the tap while brushing", "January 2024", 2L, new byte[]{});
        insertWater(28, 90.0, 45.0, "Twice a week", "Use a low-flow showerhead", "February 2024", 1L, new byte[]{});
        // Add more sample data as needed
    }

    private void insertWater(int numOfDays, double usageRM, double usageM3, String methods,
                             String practices, String month, long propFactor, byte[] bill) {
        Water water = new Water(0, numOfDays, usageRM, usageM3, methods, practices, month, propFactor, bill);

        if (waterList.isEmpty()) {
            water.setWaterId(1);
        } else {
            int lastWaterId = waterList.get(waterList.size() - 1).getWaterId();
            water.setWaterId(lastWaterId + 1);
        }

        waterList.add(water);
    }

//    public List<Water> getAllWater(int waterId) {
//        List<Water> result = new ArrayList<>();
//        
//        for (Water water : waterList) {
//            if (water.getWaterId() == waterId) {
//                result.add(water.copy());
//            }
//        }
//        
//        return result;
//    }

    @Override
    public Water addWater(Water water) {
        if (waterList.isEmpty()) {
            water.setWaterId(1);
        } else {
            int lastWaterId = waterList.get(waterList.size() - 1).getWaterId();
            water.setWaterId(lastWaterId + 1);
        }

        if (getWaterById(water.getWaterId()) == null) {
            waterList.add(water);
            return water;
        }

        return null;
    }

    @Override
    public List<Water> getAllWater() {
        return Collections.unmodifiableList(waterList);
    }

    @Override
    public Water getWaterById(int waterId) {
        for (Water water : waterList) {
            if (water.getWaterId() == waterId)
                return water;
        }
        return null;
    }

    @Override
    public Water updateWater(Water water) {
        Water found = getWaterById(water.getWaterId());
        if (found == null)
            return null;

        found.assign(water);

        return found;
    }

    @Override
    public boolean deleteWater(int waterId) {
        Water found = getWaterById(waterId);
        if (found == null) return false;

        waterList.remove(found);

        return true;
    }

    @Override
    public double calculateWater(int waterId) {
        Water water = getWaterById(waterId);

        if (water != null) {
            // Implement your calculation logic based on the properties of the Water object
            // For example, calculate total water consumption by adding usageRM and usageM3
            return water.getWaterUsageRM() + water.getWaterUsageM3();
        }

        // Return 0 if the water object with the specified ID is not found
        return 0;
    }
}