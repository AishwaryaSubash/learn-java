import java.util.Scanner;

public class ArrayOutOfBound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the index to access: ");
        int index = scanner.nextInt();
        try {
            int result = accessArrayElement(arr, index);
            System.out.println("Result: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int accessArrayElement(int[] array, int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid array index");
        }
        return array[index];
    }
}
