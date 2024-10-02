package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {

    private int id;
    private String requirementName;
    private int taskTypeID;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assigne;
    private String reviewer;

    public Task(int id, String requirementName, int taskTypeID, Date date, double planFrom, double planTo, String assigne, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assigne = assigne;
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String getTaskTypeName() {
        switch (this.taskTypeID) {
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
        }
        return null;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(date);
        return String.format("%d\t%s\t%s\t\t%s\t%.1f\t%s\t\t%s%n",
                id, requirementName, getTaskTypeName(), formattedDate,
                planTo - planFrom, assigne, reviewer);
    }

}
