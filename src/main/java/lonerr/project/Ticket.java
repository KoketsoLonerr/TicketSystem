package lonerr.project;

import java.util.Date;

public class Ticket {
    private int id;
    private String description;
    private String status;
    private String priority;
    private Date dateCreated;
    private User creator;

    //create a constructor
    public Ticket(int id, String description, String status, String priority,Date dateCreated,User creator){
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dateCreated= dateCreated;
        this.creator = creator;
    }

    //setters and getters
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getPriority(){
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public User getCreator(){
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getIssueDescription() {
        return this.description;
    }

    public java.sql.Date getDateReported() {
        return new java.sql.Date(this.dateCreated.getTime());
    }

    public String getStudentName() {
        return this.creator.getName();
    }

    public String getIssueStatus() {
        return this.status;
    }

    public int getTicketId() {
        return 0;
    }
}
