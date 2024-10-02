package j1.s.p0009;

public class J1SP0009 {

    public static void main(String[] args) {
        displayFibonacciSequence();
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    public static void displayFibonacciSequence() {
        System.out.println("The 45 sequence fibonacci: ");
        for (int i = 0; i < 45; i++) {
            System.out.print(fibonacci(i) + ", ");
            if (i % 10 == 0)
                System.out.println();
        }
        System.out.println();
    }

}
