package lonerr.project;
import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private Connection conn;
    private UserDAO userDAO;

    // Constructor
    public UserService(Connection conn) {
        this.conn = conn;
        this.userDAO = new UserDAO(conn);
    }

    // Method to add a new user to the database
    public boolean addUser(User user) throws SQLException {
        return userDAO.addUser(user);
    }

    // Method to get a user by username and password
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        return userDAO.getUserByUsernameAndPassword(username, password);
    }
}
