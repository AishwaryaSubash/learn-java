import java.util.TreeSet;

public class CloneATreeset {
    public static void main(String[] args) {
        TreeSet<Integer> originalSet = new TreeSet<>();
        originalSet.add(10);
        originalSet.add(20);
        originalSet.add(30);
        TreeSet<Integer> clonedSet = new TreeSet<>(originalSet);
        System.out.println("Original TreeSet: " + originalSet);
        System.out.println("Cloned TreeSet: " + clonedSet);
    }
}
