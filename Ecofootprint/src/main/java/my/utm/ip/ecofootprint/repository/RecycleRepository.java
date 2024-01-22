package my.utm.ip.ecofootprint.repository;

import java.util.List;

import my.utm.ip.ecofootprint.model.DAO.RecycleDAO;

public interface RecycleRepository {

	List<RecycleDAO> getAllRecycle();

	RecycleDAO getRecycleById(int recycleId);

	RecycleDAO addRecycle(final RecycleDAO recycle);

	RecycleDAO updateRecycle(final RecycleDAO recycle);

	public boolean deleteRecycle(int recycleId);

    int getRecycleIdByUserId(int userId);
}
