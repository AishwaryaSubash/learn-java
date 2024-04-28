import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapToTreeMap {
    public static void main(String[] args) {
        HashMap<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Apple", 10);
        unsortedMap.put("Banana", 5);
        unsortedMap.put("Orange", 8);
        unsortedMap.put("Mango", 15);
        unsortedMap.put("Pineapple", 3);
        System.out.println("Unsorted HashMap:");
        displayMap(unsortedMap);
        TreeMap<String, Integer> sortedMap = new TreeMap<>(unsortedMap);
        System.out.println("\nSorted TreeMap:");
        displayMap(sortedMap);
    }

    public static void displayMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
