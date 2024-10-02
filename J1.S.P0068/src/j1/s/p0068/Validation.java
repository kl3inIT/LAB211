/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0068;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
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
    
    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();                
                return n;
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
