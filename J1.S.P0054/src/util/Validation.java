package util;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);
    private static final String[] VALID_PHONE = {"[0-9]{10}",
        "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}",
        "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}\\s[x][0-9]{4}",
        "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}\\sext[0-9]{4}",
        "\\([0-9]{3}\\)\\-[0-9]{3}\\-[0-9]{4}",
        "[0-9]{3}\\.[0-9]{3}\\.[0-9]{4}",
        "[0-9]{3}\\s[0-9]{3}\\s[0-9]{4}"};

    public static String getString(String inputMsg, String errorMsg) {
        while (true) {
            System.out.print(inputMsg);
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.err.println(errorMsg);
            } else {
                return string;
            }
        }
    }
    
    public static String getName() {
        while (true) {
            String name = getString("Enter name: ", "Name is required");
            String[] strings = name.split("\\s+");
            
            if (strings.length < 2) {
                System.err.println("Please input your name in the format: First Name + Last Name.");
            } else {
                return name;
            }
        }           
    }

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getPhone() {
        while (true) {
            String phone = getString("Enter Phone: ", "Phone is required.");
            for (String phoneNumber : VALID_PHONE) {
                if (phone.matches(phoneNumber)) {
                    return phone;
                }
            }
            System.err.println("Please input Phone follow\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.print("Enter again: ");
        }
    }

}
