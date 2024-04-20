import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numerator: ");
        int n = scanner.nextInt();
        System.out.print("Enter the denominator: ");
        int d = scanner.nextInt();
        try {
            int result = division(n, d);
            System.out.println("Result: " + result);
        } catch (DivideByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }

    private static int division(int n, int d) throws DivideByZeroException {
        if (d == 0) {
            throw new DivideByZeroException("Division by zero is not allowed.");
        }
        return n / d;
    }
}

class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}
