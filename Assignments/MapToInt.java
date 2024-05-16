import java.util.Arrays;
import java.util.List;

public class MapToInt {
    public static void main(String[] args) {
        List<String> numberStrings = Arrays.asList("1", "2", "3", "4", "5");
        int sum = numberStrings.stream()
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("Sum of all integers: " + sum);
    }
}
