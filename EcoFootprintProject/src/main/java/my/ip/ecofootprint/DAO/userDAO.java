package my.ip.ecofootprint.DAO;

import java.util.List;

import my.ip.ecofootprint.model.User;

public interface userDAO {
    
    List<User> getAllUsers();
    User getUserById(int userId);
    User addUser(final User user);
    User updateUser(final User user);
    boolean deleteUser(int userId);
}