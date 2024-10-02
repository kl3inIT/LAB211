package j1.s.p0061;

import java.util.Scanner;

public class getInput {

    private double getADouble(String inputMsg) {
        double output;
        while (true) {
            try {
                System.out.print(inputMsg);
                Scanner sc = new Scanner(System.in);
                output = Double.parseDouble(sc.nextLine().trim());
                if (output < 0) {
                    throw new Exception();
                }
                return output;
            } catch (NumberFormatException stringInput) {
                System.out.println("Input can not be string");
            } catch (Exception negativeInput) {
                System.out.println("Input can not be negative");
            }
        }
    }

    public Triangle inputTriangle() {
        while (true) {
            double sideA = getADouble("Please input side A of Triangle: ");
            double sideB = getADouble("Please input side B of Triangle: ");
            double sideC = getADouble("Please input side C of Triangle: ");

            if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
                return new Triangle(sideA, sideB, sideC);
            } else {
                System.out.println("Sum of any 2 side have to be larger than the"
                        + "other to form a triangle");
            }
        }
    }

    public Rectangle inputRectangle() {
            double width = getADouble("Please input side width of Rectangle: ");
            double length = getADouble("Please input side length of Rectangle: ");
            return new Rectangle(width, length);
    }

    public Circle inputCircle() {
            double radius = getADouble("Please input radius of Circle: ");
            return new Circle(radius);
    }

}
