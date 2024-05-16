import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLen {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length)); 
        groupedByLength.forEach((length, strings) -> {
            System.out.println("Strings with length " + length + ": " + strings);
        });
    }
}
