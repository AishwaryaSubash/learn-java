import java.util.LinkedList;

public class AppendToLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");
        System.out.println("Original Linked List: " + linkedList);
        linkedList.addLast("Grapes");
        System.out.println("Linked List after appending: " + linkedList);
    }
}
