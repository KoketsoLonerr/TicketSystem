package lonerr.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
   private Connection conn;

   // Constructor
   public UserDAO(Connection conn) {
       this.conn = conn;
   }

   // Method to check if a user exists in the database with the given username and password
   public boolean checkLogin(String username, String password) throws SQLException {
       String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, username);
       statement.setString(2, password);
       ResultSet result = statement.executeQuery();
       return result.next();
   }

   // Method to retrieve a user record from the database with the given username
   public User getUserByUsername(String username) throws SQLException {
       String sql = "SELECT * FROM users WHERE username = ?";
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, username);
       ResultSet result = statement.executeQuery();
       if (result.next()) {
           User user = new User(
                   result.getInt("user_id"),
                   result.getString("username"),
                   result.getString("password"),
                   result.getString("role"), sql
           );
           return user;
       } else {
           return null;
       }
   }

   // Method to add a new user to the database
   public boolean addUser(User user) throws SQLException {
       String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setString(1, user.getName());
       statement.setString(2, user.getPassword());
       statement.setString(3, user.getRole());
       int rowsInserted = statement.executeUpdate();
       return rowsInserted > 0;
}
    // Method to get a user by username and password
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        return this.getUserByUsernameAndPassword(username, password);
    }
}