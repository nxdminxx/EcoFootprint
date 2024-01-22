package my.utm.ip.ecofootprint.ServiceDatabaseImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.ecofootprint.Service.RecycleService;
import my.utm.ip.ecofootprint.model.Recycle;
import my.utm.ip.ecofootprint.model.Water;
import my.utm.ip.ecofootprint.model.DAO.RecycleDAO;
import my.utm.ip.ecofootprint.model.DAO.WaterDAO;
import my.utm.ip.ecofootprint.repository.RecycleRepository;

public class RecycleServiceDatabaseImpl implements RecycleService {

	@Autowired
	private RecycleRepository repo;

	@Override
	public List<Recycle> getAllRecycle() {
		RecycleDAO dao = repo.getAllRecycle();
		return new Recycle(dao);
	}

	// get data form db to view
	@Override
	public Recycle getRecycleById(int recycleId) {
		RecycleDAO dao = repo.getRecycleById(recycleId);
		return new Recycle(dao);
	}

	// pass data from view to db
	// convert DTO -> DAO
	@Override
	public Recycle addRecycle(Recycle recycle) {
		RecycleDAO dao = recycle.toDAO();
		dao = repo.addRecycle(dao);
		return new Recycle(dao);
	}

	@Override
	public Recycle updateRecycle(Recycle recycle) {
		RecycleDAO dao = repo.updateRecycle(recycle.toDAO());
		return new Recycle(dao);
		// return repo.updateRecycle(recycle);
	}

	@Override
	public boolean deleteRecycle(int recycleId) {
		return repo.deleteRecycle(recycleId);
	}

	@Override
	public double calculateRecycle(int recycleId) {
		RecycleDAO dao = repo.getRecycleById(recycleId);
		if (dao != null)
			return 0.0;

		Recycle recycle = new Recycle(dao);
		double carbonFootprint = (recycle.getRecycleTotalInKG() * recycle.getRecycelAccumulatedTotalInRM());

		recycle.setCarbonResult(carbonFootprint);

		repo.updateRecycle(recycle.toDAO());
		return carbonFootprint;

	}

	@Override
	public int getRecycleIdByUserId(int userId) {
		return repo.getRecycleIdByUserId(userId);
	}
}
