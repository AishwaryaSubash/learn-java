import java.util.*;
import jdk.jshell.*;

public class EnhancedCalculator {
    private static Map<String, String> history = new LinkedHashMap<>();

    public static void main(String[] args) {
        JShell jShell = JShell.create();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a mathematical expression, 'history', or 'exit': ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (input.equalsIgnoreCase("history")) {
                displayHistory();
                continue;
            }
            String jShellCode = input + ";";
            String result = jShell.eval(jShellCode).get(0).value();
            history.put(input, result);
            System.out.println("Result: " + result);
        }
        jShell.close();
        System.out.println("Exiting the program...");
    }

    private static void displayHistory() {
        System.out.println("Expression History:");
        for (Map.Entry<String, String> entry : history.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
