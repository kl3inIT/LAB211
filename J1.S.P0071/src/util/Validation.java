package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private static final Scanner sc = new Scanner(System.in);

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

    public static Date getDate(String inputMsg, String errorMsg) {
        while (true) {
            System.out.print(inputMsg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            try {
                return dateFormat.parse(sc.nextLine().trim());
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }

}
