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

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Database connection established successfully.");

            // Create instances of TicketService and UserService
            TicketService ticketService = new TicketService(conn);
            UserService userService = new UserService(conn);

            // You can interact with services here as needed.

        } catch (SQLException e) {
            System.out.println("Error establishing database connection: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection closed successfully.");
                } catch (SQLException e) {
                    System.out.println("Error closing database connection: " + e.getMessage());
                }
            }
        }
    }
}




// public class Main {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         // Get user input for database configuration
//         System.out.print("Enter database URL: ");
//         String dbUrl = scanner.nextLine();
//         System.out.print("Enter database username: ");
//         String dbUsername = scanner.nextLine();
//         System.out.print("Enter database password: ");
//         String dbPassword = scanner.nextLine();

//         // Establish database connection
//         try {
//             Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
//             System.out.println("Database connection established successfully.");

//             // Create instances of TicketService and UserService
//             TicketService ticketService = new TicketService(conn);
//             UserService userService = new UserService(conn);

//             // Close database connection
//             conn.close();
//             System.out.println("Database connection closed successfully.");
//         } catch (SQLException e) {
//             System.out.println("Error establishing database connection: " + e.getMessage());
//         }
//     }

// }









//MY ONLY PROBLEM IS MYSQL CONNECTION