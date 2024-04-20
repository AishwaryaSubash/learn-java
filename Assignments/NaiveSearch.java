import java.io.*;

public class NaiveSearch {
    public static void main(String[] args) {
        String innocentTextFileName = "innocent_text.txt";
        String messageToFindFileName = "message_to_find.txt";
        try {
            String innocentText = readFile(innocentTextFileName);
            String messageToFind = readFile(messageToFindFileName);

            int comparisons = naiveSearch(innocentText, messageToFind);
            System.out.println("Naive Search - Comparisons: " + comparisons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int naiveSearch(String text, String pattern) {
        int comparisons = 0;
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                comparisons++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return comparisons;
            }
        }
        return comparisons;
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
