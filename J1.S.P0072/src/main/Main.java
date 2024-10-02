package main;

import controller.Manager;
import ui.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu("============ Login Program ============");
        menu.addNewOption("1. Add User");
        menu.addNewOption("2. Login");
        menu.addNewOption("3. Exit");
        Manager manager = new Manager();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    manager.addAccound();
                    break;
                case 2:
                    manager.login();
                    break;
                case 3:
                    System.out.println("Bye Bye, See you in next time");
                    break;
            }          
        } while (choice != 3);
    }

}
