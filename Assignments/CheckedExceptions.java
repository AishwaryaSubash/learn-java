import java.io.*;

// A. CheckedExceptions
public class CheckedExceptions {
    public static void main(String[] args) {
        try {
            readFile("new.txt");
        } catch (IOException e) {
            System.out.println("An IOException occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }

    public static void readFile(String fileName) throws IOException {
        if (!fileName.equals("new.txt")) {
            throw new IOException("File not found");
        }
        System.out.println("Reading file: " + fileName);
    }
}
