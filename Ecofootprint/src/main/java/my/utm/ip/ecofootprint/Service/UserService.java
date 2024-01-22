package my.utm.ip.ecofootprint.Service;

import java.util.List;

import my.utm.ip.ecofootprint.model.User;

public interface UserService {
	
	List<User> getAllUsers();

	User getUserById(int userId);

	User addUser(final User userDAO);

	User updateUser(final User userDAO);

    boolean deleteUser(int userId);
    
    boolean isUsernameTaken(String username);
	
}
