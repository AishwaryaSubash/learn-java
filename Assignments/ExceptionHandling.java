class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}

class DataProcessor {
    public double processData(int[] data) throws InvalidDataException {
        if (data == null || data.length == 0) {
            throw new InvalidDataException("Array is empty or null");
        }
        double sum = 0;
        for (int num : data) {
            sum += num;
        }
        return sum / data.length;
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        try {
            int[] dataArray = { 10, 20, 30, 40, 50 };
            double average = processor.processData(dataArray);
            System.out.println("Average: " + average);
            int[] emptyArray = {};
            double emptyArrayAverage = processor.processData(emptyArray);
            System.out.println("Average of empty array: " + emptyArrayAverage);
        } catch (InvalidDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
