package my.ip.ecofootprint.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import my.ip.ecofootprint.DAO.userDAO;
import my.ip.ecofootprint.model.User;

public class UserService implements userDAO {
    private static final String JDBC_URL = "jdbc:mysql://your_mysql_host:your_mysql_port/your_database_name";
    private static final String JDBC_USER = "your_mysql_username";
    private static final String JDBC_PASSWORD = "your_mysql_password";

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = extractUserFromResultSet(resultSet);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "SELECT * FROM users WHERE userId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        user = extractUserFromResultSet(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User addUser(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "INSERT INTO users (username, password, role, email, idCard, name, contact, status, address, category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getIdCard());
                preparedStatement.setString(6, user.getName());
                preparedStatement.setString(7, user.getContact());
                preparedStatement.setString(8, user.getStatus());
                preparedStatement.setString(9, user.getAddress());
                preparedStatement.setString(10, user.getCategory());

                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            user.setUserId(generatedKeys.getInt(1));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "UPDATE users SET username=?, password=?, role=?, email=?, idCard=?, name=?, contact=?, status=?, address=?, category=? WHERE userId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getIdCard());
                preparedStatement.setString(6, user.getName());
                preparedStatement.setString(7, user.getContact());
                preparedStatement.setString(8, user.getStatus());
                preparedStatement.setString(9, user.getAddress());
                preparedStatement.setString(10, user.getCategory());
                preparedStatement.setInt(11, user.getUserId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteUser(int userId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String query = "DELETE FROM users WHERE userId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                int affectedRows = preparedStatement.executeUpdate();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("userId"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("role"),
                resultSet.getString("email"),
                resultSet.getString("idCard"),
                resultSet.getString("name"),
                resultSet.getString("contact"),
                resultSet.getString("status"),
                resultSet.getString("address"),
                resultSet.getString("category")
        );
    }
}
