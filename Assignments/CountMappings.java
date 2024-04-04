import java.util.HashMap;
import java.util.Map;

public class CountMappings {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        int size = map.size();
        System.out.println("Map: " + map);
        System.out.println("Number of key-value mappings: " + size);
    }
}
