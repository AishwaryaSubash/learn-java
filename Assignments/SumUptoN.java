import java.util.Scanner;

public class SumUptoN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();

        // Calculate the sum of numbers upto N
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }

        // Calculate the sum of divisors for each number upto N
        int sumOfDivisors = 0;
        for (int i = 1; i <= N; i++) {
            sumOfDivisors += getSumOfDivisors(i);
        }
        System.out.println("Sum of numbers upto " + N + " is: " + sum);
        System.out.println("Sum of divisors for each number upto " + N + " is: " + sumOfDivisors);
        scanner.close();
    }

    public static int getSumOfDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
