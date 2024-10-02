package main;

import controller.Manager;
import ui.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu("CANDIDATE MANAGEMENT SYSTEM");
        menu.addNewOption("1. Experience");
        menu.addNewOption("2. Fresher");
        menu.addNewOption("3. Internship");
        menu.addNewOption("4. Searching");
        menu.addNewOption("5. Exit");
        Manager manager = new Manager();
        int choice;
        do {
            menu.printMenu();
            System.out.println("(Please choose 1 to Create Experience Candidate,"
                    + " 2 to Create Fresher Candidate, 3 to Internship Candidate, "
                    + "4 to Searching and 5 to Exit program).");
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    manager.createCandidate(0);
                    break;
                case 2:
                    manager.createCandidate(1);
                    break;
                case 3:
                    manager.createCandidate(2);
                    break;
                case 4:
                    manager.searchCandidate();
                    break;
                case 5:
                    System.out.println("Bye Bye, See you in next time");
                    break;
            }
        } while (choice != 5);
    }

}
