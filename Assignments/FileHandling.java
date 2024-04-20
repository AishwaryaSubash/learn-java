import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandling {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        try {
            readFromFile(fileName);
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    private static void readFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
