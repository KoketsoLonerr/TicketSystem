package lonerr.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection conn;

    public DatabaseConnection(){
        conn = null;
    }
    public void connect() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/ticket_system";  // find the correct database configuration details (MySQL, check hosting service
        String user = "root";
        String password = "1234";

        conn = DriverManager.getConnection(url,user,password);
        System.out.println("Database connection established.");
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