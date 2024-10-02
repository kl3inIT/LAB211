package controller;

import model.Task;
import util.Validation;

import java.util.ArrayList;

public class TaskList {

    private final ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
        System.out.println("Add success!!!");
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    // có thể để boolean thay vì dùng while (or dùng getChoice)
    public void deleteTask(int id) {
        while (true) {
            Task task = searchTaskObjectById(id);
            if (task != null) {
                taskList.remove(task);
                for (int i = id - 1; i < taskList.size(); i++) {
                    taskList.get(i).setId(i + 1);
                }
                System.out.println("Task deleted successfully!!");
                break;
            } else {
                System.out.println("The task ID is not exist!!");
            }
        }
    }

    private Task searchTaskObjectById(int id) {
        if (taskList.isEmpty()) {
            return null;
        }

        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void getDataTasks() {
        System.out.println("ID\tName\tTask Type\tDate\t\tTime\tAssignee\tReviewer");
        for (Task task : taskList) {
            System.out.print(task.toString());
        }
    }
}
