package data;

import java.util.ArrayList;
import util.Validation;

public class ContactManager {

    private final ArrayList<Contact> contactList = new ArrayList<>();
    private int nextId = 1;

    public void addContact() {
        System.out.println("-------- Add a Contact --------");
        String name = Validation.getName();
        String[] fullName = name.split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[fullName.length - 1];
        String group = Validation.getString("Enter group: ", "Group is required.");
        String address = Validation.getString("Enter address: ", "Address is required.");
        String phone = Validation.getPhone();
        contactList.add(new Contact(nextId++, name, group, address, phone, lastName, firstName));
        System.out.println("Contact is added successfully");
    }

    public void displayAll() {
        if (contactList.isEmpty()) {
            System.err.println("Contact list id empty. Nothing to print.");
            return;
        }
        System.out.println("------ Dislpay All Contact -------");
        System.out.printf("%-5s%-25s%-20s%-20s%-20s%-20s%-20s\n", "Id", "Name",
                "First name", "Last name", "Group", "Address", "Phone");

        for (Contact contact : contactList) {
            System.out.printf("%-5d%-25s%-20s%-20s%-20s%-20s%-20s\n",
                    contact.getId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }

    }
    
    public void deleteContact() {
        System.out.println("------- Delete a Contact -------");
        int id = Validation.getAnInteger("Enter ID: ", "ID is digit");
        Contact contact = findContactObjectByID(id);
        if (contact == null) {
            System.err.println("No found contact");
            return;
        }
        
        contactList.remove(contact);
        System.out.println("Successfull");
    }
    
    private Contact findContactObjectByID(int id) {
        if (contactList.isEmpty()) {
            return null;
        }
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

}
