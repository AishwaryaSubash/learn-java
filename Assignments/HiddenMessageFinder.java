import java.io.*;

public class HiddenMessageFinder {
    public static void main(String[] args) {
        String innocentTextFileName = "innocent_text.txt";
        String messageToFindFileName = "message_to_find.txt";

        try {
            String innocentText = readFile(innocentTextFileName);
            String messageToFind = readFile(messageToFindFileName);
            if (innocentText.contains(messageToFind)) {
                System.out.println("Message found inside given file");
            } else {
                System.out.println("Message not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
