package lonerr.project;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TicketDAO {
    private Connection conn;

    // Constructor
    public TicketDAO(Connection conn) {
        this.conn = conn;
    }
    public boolean addTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO tickets (student_name, issue_description, date_reported) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, ticket.getStudentName());
        statement.setString(2, ticket.getIssueDescription());
        statement.setDate(3, (Date) ticket.getDateReported());

        int rowsInserted = statement.executeUpdate();
        
        // Return true if a row was successfully inserted, false otherwise
        return rowsInserted > 0;
    }

    // Method to insert a new ticket record into the database
    public void insertTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO tickets (student_name, issue_description, date_reported) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, ticket.getStudentName());
        statement.setString(2, ticket.getIssueDescription());
        statement.setDate(3, (Date) ticket.getDateReported());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new ticket was inserted successfully!");
        }
    }

    // Method to update an existing ticket record in the database
    public void updateTicket(Ticket ticket) throws SQLException {
        String sql = "UPDATE tickets SET issue_status = ?, issue_solution = ?, date_resolved = ? WHERE ticket_id = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, ticket.getIssueStatus());
        statement.setString(2, ticket.getIssueSolution());
        statement.setDate(3, (Date) ticket.getDateResolved());
        statement.setInt(4, ticket.getTicketId());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("The ticket with ID " + ticket.getTicketId() + " was updated successfully!");
        }
    }

    // Method to retrieve a list of all ticket records from the database
    public List<Ticket> getAllTickets() throws SQLException {
        String sql = "SELECT ticket_id, student_name, issue_description, issue_status, issue_solution, date_reported, date_resolved FROM tickets";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<Ticket> ticketList = new ArrayList<>();
        while (result.next()) {
            User user = new User(
                result.getInt("user_id"),
                result.getString("user_name"), sql, sql, sql
            );

            Ticket ticket = new Ticket(
                result.getInt("ticket_id"),
                result.getString("student_name"),
                result.getString("issue_description"),
                result.getString("issue_status"),
                result.getString("issue_solution"),
                result.getDate("date_reported"),
                result.getDate("date_resolved"),
                user // Assuming the User object is passed to the Ticket constructor
            );

            ticketList.add(ticket);
        }

        return ticketList;
    }

    public List<Ticket> getTicketsByStudent(int userId) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        
        // Write your SQL query to get tickets by student
        String sql = "SELECT * FROM tickets WHERE student_id = ?";
        
        // Use your connection to prepare the statement
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        // Set the parameter in the query
        stmt.setInt(1, userId);
        
        // Execute the query and get the result set
        ResultSet rs = stmt.executeQuery();
        
        // Iterate over the result set and create Ticket objects
        while (rs.next()) {
            Ticket ticket = new Ticket(
                rs.getInt("ticket_id"),
                rs.getString("student_name"),
                rs.getString("issue_description"),
                rs.getString("issue_status"),
                rs.getString("issue_solution"),
                rs.getDate("date_reported"),
                rs.getDate("date_resolved"),
                null
                // You might need to pass the User object here if needed
            );
            tickets.add(ticket);
        }
        
        // Return the list of tickets
        return tickets;
    }
     // Method to retrieve tickets by technician ID from the database
    public List<Ticket> getTicketsByTechnician(int technicianId) throws SQLException {
        List<Ticket> tickets = new ArrayList<>();

        // Write your SQL query to get tickets by technician
        String sql = "SELECT * FROM tickets WHERE technician_id = ?";

        // Use your connection to prepare the statement
        PreparedStatement stmt = conn.prepareStatement(sql);

        // Set the parameter in the query
        stmt.setInt(1, technicianId);

        // Execute the query and get the result set
        ResultSet rs = stmt.executeQuery();

        // Iterate over the result set and create Ticket objects
        while (rs.next()) {
            Ticket ticket = new Ticket(
                rs.getInt("ticket_id"),
                rs.getString("student_name"),
                rs.getString("issue_description"),
                rs.getString("issue_status"),
                rs.getString("issue_solution"),
                rs.getDate("date_reported"),
                rs.getDate("date_resolved"),
                null
                // You might need to pass the User object here if needed
            );
            tickets.add(ticket);
        }

        // Return the list of tickets
        return tickets;
    }


    public boolean updateTicketStatus(int ticketId, String status) throws SQLException {
        String sql = "UPDATE tickets SET status = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, status);
        pstmt.setInt(2, ticketId);
        int updatedRows = pstmt.executeUpdate();
        return updatedRows > 0;
    }
}

