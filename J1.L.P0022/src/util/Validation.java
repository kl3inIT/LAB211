package util;

import java.util.Scanner;

public class Validation {

    private final static Scanner sc = new Scanner(System.in);

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

    public static String getGraduationRank() {
        while (true) {
            String graduationRank = getString("Input Graduation Rank(Excellence,"
                    + " Good, Fair, Poor): ", "Graduation Rank is required!");
            if (graduationRank.equalsIgnoreCase("excellence")
                    || graduationRank.equalsIgnoreCase("good")
                    || graduationRank.equalsIgnoreCase("fair")
                    || graduationRank.equalsIgnoreCase("poor")) {
                return graduationRank.substring(0, 1).toUpperCase()
                        + graduationRank.substring(1).toLowerCase();
            } else {
                System.err.println("There are only four Graduation Rank: Excellence,"
                        + "Good, Fair, Poor");
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

//    public static String getBirthDate(String inputMsg, String errorMsg) {
//
//        while (true) {
//            System.out.print(inputMsg);
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//            dateFormat.setLenient(false);
//            try {
//                Date date = dateFormat.parse(sc.nextLine());
//                Date curDate = Calendar.getInstance().getTime();
//
//                if (curDate.compareTo(date) < 0) {
//                    throw new Exception();
//                }
//
//                return dateFormat.format(date);
//            } catch (Exception e) {
//                System.out.println(errorMsg);
//            }
//        }
//    }
}
