package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static String getValidString(String inputMsg, String errorMsg, String format) {
        while (true) {
            System.out.print(inputMsg);
            String string = sc.nextLine().trim().toUpperCase();
            boolean match = string.matches(format);
            if (string.isEmpty() || !match) {
                System.err.println(errorMsg);
            } else {
                return string;
            }
        }
    }

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

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        while (true) {
            try {
                System.out.print(inputMsg);
                int n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }

    public static Date getBirthDate(String inputMsg, String errorMsg) {
        while (true) {
            System.out.print(inputMsg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try {
                Date date = dateFormat.parse(sc.nextLine().trim());
                Date now = new Date();

                if (date.after(now)) {
                    throw new Exception();
                }

                return date;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }

    public static boolean getChoice(String inputMsg, String errorMsg, String trueOption, String falseOption) {
        while (true) {
            String input = getString(inputMsg, errorMsg);
            if (input.equalsIgnoreCase(trueOption)) {
                return true;
            }
            if (input.equalsIgnoreCase(falseOption)) {
                return false;
            }
            System.err.println(errorMsg);
        }
    }
}
