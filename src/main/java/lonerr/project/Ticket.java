package lonerr.project;

import java.util.Date;

public class Ticket {
    private int ticketId;
    private String issueDescription;
    private String issueStatus;
    private User user;
    private Date dateReported;
    private String studentName;
    private String issueSolution;
    private Date dateResolved;

    public Ticket(int ticketId, String studentName, String issueDescription, String issueStatus, String issueSolution, Date dateReported, Date dateResolved, User user) {
        this.ticketId = ticketId;
        this.issueDescription = issueDescription;
        this.issueStatus = issueStatus;
        this.user = user;
        this.dateReported = dateReported;
        this.studentName = studentName;
        this.issueSolution = issueSolution;
        this.dateResolved = dateResolved;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public Date getDateReported() {
        return dateReported;
    }

    public void setDateReported(Date dateReported) {
        this.dateReported = dateReported;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getIssueSolution() {
        return issueSolution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateResolved() {
        return dateResolved;
    }
}
