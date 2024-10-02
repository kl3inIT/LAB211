package main;

import controller.TaskList;
import model.Task;
import ui.Menu;
import util.Validation;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu("\n======== Task program =========");
        menu.addNewOption("1. Add Task");
        menu.addNewOption("2. Delete Task");
        menu.addNewOption("3. Display Task");
        menu.addNewOption("4. Exit");

        TaskList taskList = new TaskList();
        int choice;
        int id = 1;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("\n------------Add Task---------------");
                    String requirementName = Validation.getString("Requirement Name: ", "Requirement Name is required.");
                    int taskTypeId = Validation.getAnInteger("Task Type: ", "Task Type is from 1 to 4", 1, 4);
                    Date date = Validation.getDate("Date: ", "Valid Date Format is dd-MM-yyyy");
                    double planFrom = Validation.getADouble("From: ", "Plan From must be less than Plan To and within 8h-17h", 8, 17.5);
                    double planTo = Validation.getADouble("To: ", "Plan To must be larger than Plan From and within 8h-17h", planFrom, 17.5);
                    String assignee = Validation.getString("Assignee: ", "Assignee is required.");
                    String reviewer = Validation.getString("Reviewer: ", "Reviewer is required.");
                    Task task = new Task(id, requirementName, taskTypeId, date, planFrom, planTo, assignee, reviewer);
                    taskList.addTask(task);
                    id++;
                    break;
                case 2:
                    System.out.println("\n---------Del Task------");
                    int idDelete = Validation.getAnInteger("ID: " , "ID must be from 1 to " + taskList.getTaskList().size(),
                    1, taskList.getTaskList().size());
                    taskList.deleteTask(idDelete);
                    id--;
                    break;
                case 3:
                    System.out.println("\n----------------------------------------- Task ---------------------------------------");
                    taskList.getDataTasks();
                    break;
                case 4:
                    System.out.println("Bye Bye, See you in next time");
                    break;
            }
        } while (choice != 4);
    }

}
