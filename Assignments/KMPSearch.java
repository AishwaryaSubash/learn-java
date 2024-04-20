import java.io.*;

public class KMPSearch {
    public static void main(String[] args) {
        String innocentTextFileName = "innocent_text.txt";
        String messageToFindFileName = "message_to_find.txt";
        try {
            String innocentText = readFile(innocentTextFileName);
            String messageToFind = readFile(messageToFindFileName);
            int comparisons = kmpSearch(innocentText, messageToFind);
            System.out.println("KMP Search - Comparisons: " + comparisons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int kmpSearch(String text, String pattern) {
        int comparisons = 0;
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPSArray(pattern);
        int i = 0; 
        int j = 0; 
        while (i < n) {
            comparisons++;
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return comparisons;
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return comparisons;
    }

    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; 
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
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
