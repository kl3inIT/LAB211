package j1.s.p0061;

public class J1SP0061 {
    
    public static void displayResult(Rectangle rectangle, Circle circle, Triangle triangle) {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

    public static void main(String[] args) {
        getInput getData = new getInput();
        Rectangle rectangle = getData.inputRectangle();
        Circle circle = getData.inputCircle();
        Triangle triangle = getData.inputTriangle();
        displayResult(rectangle, circle, triangle);
    }

}
