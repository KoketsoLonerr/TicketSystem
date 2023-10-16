package lonerr.project;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private Connection conn;

    public DatabaseConnection(){
        conn = null;
    }
    public void connect() throws SQLException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading configuration file: " + e.getMessage());
            throw new SQLException("Error loading configuration file.", e);
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            System.err.println("Error establishing database connection: " + e.getMessage());
            throw e;
        }
    }


    public void disconnect()throws SQLException{
        if (conn != null){
            conn.close();
            System.out.println("Database connection closed.");
        }
    }

    public Connection getConnection(){
        return conn;
    }
}


//still under construction!!!!!!!!