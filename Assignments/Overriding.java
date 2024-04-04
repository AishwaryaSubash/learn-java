import java.util.Arrays;

public class Overriding {
    public static void main(String[] args) {
        int[] numbers = { 5, 2, 8, 3, 1 };
        System.out.println("Original Array: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }
}
