package my.utm.ip.ecofootprint.ServiceDatabaseImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import my.utm.ip.ecofootprint.Service.UserService;
import my.utm.ip.ecofootprint.model.Recycle;
import my.utm.ip.ecofootprint.model.User;
import my.utm.ip.ecofootprint.model.Water;
import my.utm.ip.ecofootprint.model.DAO.RecycleDAO;
import my.utm.ip.ecofootprint.model.DAO.UserDAO;
import my.utm.ip.ecofootprint.model.DAO.WaterDAO;
import my.utm.ip.ecofootprint.repository.UserRepository;

public class UserServiceDatabaseImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public List<User> getAllUsers() {
		UserDAO dao = new repo.getAllWater();
		return new User(dao);
	}

	@Override
	public User getUserById(int userId) {
		UserDAO dao = repo.getUserById(userId);
		return new User(dao);
	}

	@Override
	public User addUser(User user) {
		UserDAO dao = user.toDAO();
		dao = repo.addUser(dao);
		return new User(dao);
		// return repo.addUser(user);
	}

	@Override
	public User updateUser(User user) {
		UserDAO dao = repo.updateUser(user.toDAO());
		return new User(dao);
	}

	@Override
	public boolean deleteUser(int userId) {
		return repo.deleteUser(userId);
	}

	@Override
	public boolean isUsernameTaken(String username) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'isUsernameTaken'");
	}

}
