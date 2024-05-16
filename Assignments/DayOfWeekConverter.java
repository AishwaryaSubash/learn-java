import java.util.Scanner;

public class DayOfWeekConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number representing the day of the week: ");
        int dayOfWeek = scanner.nextInt();
        String dayName;
        switch (dayOfWeek) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            default:
                dayName = "Invalid input: Please enter a number between 1 and 5.";
        }
        System.out.println("Day of the week: " + dayName);
        scanner.close();
    }
}
