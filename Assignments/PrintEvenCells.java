public class PrintEvenCells {
    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50 };
        System.out.println("Values in even cells in the array:");
        for (int i = 0; i < array.length; i += 2) {
            System.out.println("Index " + i + ": " + array[i]);
        }
    }
}
