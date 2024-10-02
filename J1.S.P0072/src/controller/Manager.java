package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.DatatypeConverter;
import model.User;
import util.Validation;

public class Manager {

    private final ArrayList<User> userList = new ArrayList<>();

    public void addAccound() {
        System.out.println("---------- Add User --------");
        String userName;

        while (true) {
            userName = Validation.getString("Account: ",
                    "Account Name is required.");

            User user = searchUserObjectByName(userName);

            if (user != null) {
                System.err.println("User name is already exist. Please input another one.");
            } else {
                break;
            }
        }

        String password = Validation.getString("Password: ",
                "Password is required.");

        String name = Validation.getValidString("Name: ",
                "Please input valid name.", "[A-Za-z\\s]+");

        String phone = Validation.getValidString("Input phone number: ",
                "Phone is number with 10 or 11 characters",
                "^\\d{10,11}$");

        String email = Validation.getValidString("Email: ",
                "Format of email is <account name>@<domain>.",
                "^[A-Za-z0-9+._-]+@[A-Za-z.-]+\\.[A-Za-z]{2,}$");

        String address = Validation.getString("Address: ",
                "Address is required");

        Date dateOfBirth = Validation.getBirthDate("DOB: ", "Format of Date is dd/MM/yyyy.");

        userList.add(new User(userName, MD5Encryption(password), name, phone, email, address, dateOfBirth));
        System.out.println("Add success!!!");
    }

    private User searchUserObjectByName(String userName) {
        if (userList.isEmpty()) {
            return null;
        }

        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                return user;
            }
        }

        return null;
    }

    public void login() {
        if (userList.isEmpty()) {
            System.err.println("User List is empty. Can not login now.");
            return;
        }

        String userName = Validation.getString("Account: ",
                "Account Name is required.");

        String password = Validation.getString("Password: ",
                "Password is required.");

        User userLogin = findAccound(userName, password);

        if (userLogin != null) {
            System.out.println("------------ Wellcome -----------");
            if (Validation.getChoice("Hi " + userName + ", do you want change password now? Y/N: ",
                    "Please input Y/y or N/n", "Y", "N")) {
                changePassword(userLogin);
            }
        } else {
            System.err.println("Invalid username or password.");
        }
    }

    private void changePassword(User userLogin) {
        String oldPassword = Validation.getString("Old Password: ",
                "Old Password is required.");

        if (!MD5Encryption(oldPassword).equalsIgnoreCase(userLogin.getPassword())) {
            System.err.println("Old Password is incorrect");
            return;
        }

        String newPassword = Validation.getString("New Password: ",
                "New Password is required.");

        if (MD5Encryption(newPassword).equalsIgnoreCase(oldPassword)) {
            System.err.println("Old Password and New Password can not be the same.");
            return;
        }

        String reNewPassword = Validation.getString("Renew Password: ",
                "New Password is required.");

        if (!newPassword.equalsIgnoreCase(reNewPassword)) {
            System.err.println("New Password and Renew Password must be the same.");
            return;
        }

        userLogin.setPassword(MD5Encryption(newPassword));
        System.out.println("Change password succsess!");
    }

    private User findAccound(String userName, String password) {
        if (userList.isEmpty()) {
            return null;
        }
        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName)
                    && user.getPassword().equalsIgnoreCase(MD5Encryption(password))) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    private String MD5Encryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
