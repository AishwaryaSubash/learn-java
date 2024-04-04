public class StringComparison {
    public static void main(String[] args) {
        // Create two strings
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        // A. Compare using ==
        System.out.println("Comparing using ==:");
        System.out.println("str1 == str2: " + (str1 == str2));
        System.out.println("str1 == str3: " + (str1 == str3));

        // B. Compare using equals()
        System.out.println("\nComparing using equals():");
        System.out.println("str1.equals(str2): " + str1.equals(str2));
        System.out.println("str1.equals(str3): " + str1.equals(str3));

        // C. Compare using compareTo()
        System.out.println("\nComparing using compareTo():");
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2)); 
        System.out.println("str1.compareTo(str3): " + str1.compareTo(str3)); 
    }
}
