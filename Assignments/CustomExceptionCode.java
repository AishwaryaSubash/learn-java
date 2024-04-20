import java.util.Scanner;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class CustomExceptionCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        try {
            validateInput(input);
        } catch (CustomException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void validateInput(int input) throws CustomException {
        if (input < 0) {
            throw new CustomException("Input cannot be negative");
        }
    }
}
