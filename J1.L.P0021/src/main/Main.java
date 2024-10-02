package main;

import ui.Menu;
import controller.Manager;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu("WELCOME TO STUDENT MANAGEMENT");
        menu.addNewOption("1. Create");
        menu.addNewOption("2. Find and Sort");
        menu.addNewOption("3. Update and Delete");
        menu.addNewOption("4. Report");
        menu.addNewOption("5. Exit");
        Manager manager = new Manager();
        int choice;
        do {
            menu.printMenu();
            System.out.println("(Please choose 1 to Create, 2 to Find and Sort,"
                    + " 3 to Update/Delete, 4 to Report and 5 to Exit program).");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    manager.createNewStudent();
                    break;
                case 2:
                    manager.findAndSort();
                    break;
                case 3:
                    manager.updateOrDelete();
                    break;
                case 4:
                    manager.report();
                    break;
                case 5:
                    System.out.println("Bye Bye, See you in next time");
                    break;
            }
        } while (choice != 5);
    }
}
