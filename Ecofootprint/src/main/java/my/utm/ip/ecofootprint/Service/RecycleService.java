package my.utm.ip.ecofootprint.Service;

import java.util.List;

import my.utm.ip.ecofootprint.model.Recycle;
import my.utm.ip.ecofootprint.model.DAO.RecycleDAO;

public interface RecycleService {

	List<Recycle> getAllRecycle();

	Recycle getRecycleById(int recycleId);

	Recycle addRecycle(final Recycle recycleDAO);

	Recycle updateRecycle(final Recycle recycleDAO);

	public boolean deleteRecycle(int recycleId);

    double calculateRecycle(int recycleId);

    int getRecycleIdByUserId(int userId);
    
}
