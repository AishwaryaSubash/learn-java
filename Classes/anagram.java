package Classes;
import java.util.Arrays;

class Anagram {
    public static boolean validateAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static void main(String args[]) {
        boolean isAnagram = validateAnagram("meat", "team");
        if (isAnagram) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}