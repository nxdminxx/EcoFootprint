package my.ip.ecofootprint.service;

import java.util.List;

import my.ip.ecofootprint.model.Recycle;

public interface RecycleService {
	
	 List<Recycle> getAllRecycle();
	 Recycle getRecycleById(int recycleId);
	 Recycle addRecycle(final Recycle recycle);
	 Recycle updateRecycle(final Recycle recycle);
	 public boolean deleteRecyle(int recycleId);
}
