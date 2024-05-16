import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConcatStr {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "is", "fun", "with", "Streams");
        String concatenatedString = words.stream()
                .collect(Collectors.joining());
        System.out.println("Concatenated string: " + concatenatedString);
    }
}
