import java.awt.*;
import javax.swing.*;

public class SortingAlgorithmComparison extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private int[] array;
    private int[] sortedArray;
    private int[] inputSizes = { 100, 500, 1000, 2000, 5000, 10000 };
    private long[] bubbleSortTimes;
    private long[] mergeSortTimes;
    private long[] quickSortTimes;

    public SortingAlgorithmComparison() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        initializeArrays();
        runSortingAlgorithms();
    }

    private void initializeArrays() {
        bubbleSortTimes = new long[inputSizes.length];
        mergeSortTimes = new long[inputSizes.length];
        quickSortTimes = new long[inputSizes.length];
        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            array = generateRandomArray(size);
            sortedArray = array.clone();
        }
    }

    private void runSortingAlgorithms() {
        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            long startTime, endTime;
            array = generateRandomArray(size);
            sortedArray = array.clone();
            startTime = System.nanoTime();
            bubbleSort(sortedArray);
            endTime = System.nanoTime();
            bubbleSortTimes[i] = endTime - startTime;
            sortedArray = array.clone();
            startTime = System.nanoTime();
            mergeSort(sortedArray);
            endTime = System.nanoTime();
            mergeSortTimes[i] = endTime - startTime;
            sortedArray = array.clone();
            startTime = System.nanoTime();
            quickSort(sortedArray, 0, size - 1);
            endTime = System.nanoTime();
            quickSortTimes[i] = endTime - startTime;
        }
    }

    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        int y = HEIGHT - 50;
        int barWidth = (WIDTH - 100) / inputSizes.length;
        g.setColor(Color.RED);
        drawBars(g, x, y, barWidth, bubbleSortTimes);
        g.setColor(Color.BLUE);
        drawBars(g, x + barWidth, y, barWidth, mergeSortTimes);
        g.setColor(Color.GREEN);
        drawBars(g, x + 2 * barWidth, y, barWidth, quickSortTimes);
    }

    private void drawBars(Graphics g, int x, int y, int width, long[] times) {
        for (int i = 0; i < times.length; i++) {
            int barHeight = (int) (times[i] / 10000);
            g.fillRect(x + i * width, y - barHeight, width, barHeight);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Algorithm Comparison");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SortingAlgorithmComparison());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
