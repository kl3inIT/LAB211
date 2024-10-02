package ContactManagement;

import data.ContactManager;
import menu.Menu;

public class ContactManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("========= Contact program =========");
        menu.addNewOption("1. Add a Contact");
        menu.addNewOption("2. Display all Contact");
        menu.addNewOption("3. Delete a Contact");
        menu.addNewOption("4. Exit");
        
        ContactManager manager = new ContactManager();
        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    manager.addContact();
                    break;
                case 2:
                    manager.displayAll();
                    break;
                case 3:
                    manager.deleteContact();
                    break;
                case 4:
                    System.out.println("Bye bye, see you in next time");
                    break;
            }
        } while (choice != 4);
    }
}


