package my.utm.ip.ecofootprint.repository;

import java.util.List;

import my.utm.ip.ecofootprint.model.DAO.UserDAO;

public interface UserRepository {

	List<UserDAO> getAllUsers();

    UserDAO getUserById(int userId);

    UserDAO addUser(final UserDAO user);

    UserDAO updateUser(final UserDAO user);

    boolean deleteUser(int userId);
    
    boolean isUsernameTaken(String username);
    
}
