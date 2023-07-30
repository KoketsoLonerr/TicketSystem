package lonerr.project;
import java.sql.Connection;
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

    // Method to insert a new ticket record into the database
    public void insertTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO tickets (student_name, issue_description, date_reported) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, ticket.getStudentName());
        statement.setString(2, ticket.getIssueDescription());
        statement.setDate(3, ticket.getDateReported());

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
        statement.setDate(3, ticket.getDateResolved());
        statement.setInt(4, ticket.getTicketId());

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("The ticket with ID " + ticket.getTicketId() + " was updated successfully!");
        }
    }

    // Method to retrieve a list of all ticket records from the database
    public List<Ticket> getAllTickets() throws SQLException {
        String sql = "SELECT ticket_id, student_name, issue_description, issue_status, issue_solution, date_reported, date_resolved FROM tickets\n";

        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        List<Ticket> ticketList = new ArrayList<>();
        while (result.next()) {
            Ticket ticket = new Ticket(
                    result.getInt("ticket_id"),
                    result.getString("student_name"),
                    result.getString("issue_description"),
                    result.getString("issue_status"),
                    result.getString("issue_solution"),
                    result.getDate("date_reported"),
                    result.getDate("date_resolved")
            );
            ticketList.add(ticket);
        }

        return ticketList;
    }
}

