package lonerr.project;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private Connection conn;
    private TicketDAO ticketDAO;
    private UserDAO userDAO;

    // Constructor
    public TicketService(Connection conn) {
        this.conn = conn;
        this.ticketDAO = new TicketDAO(conn);
        this.userDAO = new UserDAO(conn);
    }

    // Method to add a new ticket to the database
    public boolean addTicket(Ticket ticket) throws SQLException {
        return ticketDAO.addTicket(ticket);
    }

    // Method to get a list of all tickets in the database
    public List<Ticket> getAllTickets() throws SQLException {
        return ticketDAO.getAllTickets();
    }

    // Method to get a list of all tickets in the database for a given user
    public List<Ticket> getTicketsByUser(String username) throws SQLException {
        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            return new ArrayList<Ticket>();
        } else if (user.getRole().equals("student")) {
            return ticketDAO.getTicketsByStudent(user.getId());
        } else {
            return ticketDAO.getTicketsByTechnician(user.getId());
        }
    }

    // Method to update the status of a ticket in the database
    public boolean updateTicketStatus(int ticketId, String status) throws SQLException {
        return ticketDAO.updateTicketStatus(ticketId, status);
    }
}
