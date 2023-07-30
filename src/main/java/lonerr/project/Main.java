package lonerr.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for database configuration
        System.out.print("Enter database URL: ");
        String dbUrl = scanner.nextLine();
        System.out.print("Enter database username: ");
        String dbUsername = scanner.nextLine();
        System.out.print("Enter database password: ");
        String dbPassword = scanner.nextLine();

        // Establish database connection
        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Database connection established successfully.");

            // Create instances of TicketService and UserService
            TicketService ticketService = new TicketService(conn);
            UserService userService = new UserService(conn);

            // TODO: Implement application logic here

            // Close database connection
            conn.close();
            System.out.println("Database connection closed successfully.");
        } catch (SQLException e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
        }
    }

}

