import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchInLargeDocument {
    public static void main(String[] args) {
        String searchTerm = "your_search_term";
        String filePath = "path_to_your_large_document.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    System.out.println("Found '" + searchTerm + "' at line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
