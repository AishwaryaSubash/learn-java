import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxElem {
    public static void main(String[] args) {
        List<Double> doubles = Arrays.asList(1.5, 2.8, 3.2, 2.0, 5.1);
        Optional<Double> maxElement = doubles.stream()
                .max(Double::compare); 
        if (maxElement.isPresent()) {
            System.out.println("Maximum element: " + maxElement.get());
        } else {
            System.out.println("List is empty");
        }
    }
}
