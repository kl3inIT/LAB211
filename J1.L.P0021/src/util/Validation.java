package util;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static String getID(String inputMsg, String errorMsg, String format) {
        while (true) {
            System.out.print(inputMsg);
            String id = sc.nextLine().trim().toUpperCase();
            boolean match = id.matches(format);
            if (id.isEmpty() || !match) {
                System.err.println(errorMsg);
            } else {
                return id;
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
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
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

    public static String getCourse() {
        while (true) {
            String course = getString("Input Course name: ",
                    "The course name is required!");
            if (course.equalsIgnoreCase("java")
                    || course.equalsIgnoreCase(".net")
                    || course.equalsIgnoreCase("c/c++")) {
                return course.toUpperCase();
            } else {
                System.err.println("There are only three courses: Java, .Net, C/C++");
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
