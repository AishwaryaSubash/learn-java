import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        System.out.println("Array Demo:");
        arrayDemo();
        System.out.println("\nLinked List Demo:");
        linkedListDemo();
        System.out.println("\nDouble Linked List Demo:");
        doubleLinkedListDemo();
        System.out.println("\nCircular Linked List Demo:");
        circularLinkedListDemo();
    }

    private static void arrayDemo() {
        String[] array = { "Apple", "Banana", "Orange", "Mango" };
        System.out.println("Array: " + Arrays.toString(array));
    }

    private static void linkedListDemo() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");
        linkedList.add("Mango");
        System.out.println("Linked List: " + linkedList);
    }

    private static void doubleLinkedListDemo() {
        LinkedList<String> doubleLinkedList = new LinkedList<>();
        doubleLinkedList.add("Apple");
        doubleLinkedList.add("Banana");
        doubleLinkedList.add("Orange");
        doubleLinkedList.add("Mango");
        System.out.println("Double Linked List: " + doubleLinkedList);
    }

    private static void circularLinkedListDemo() {
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>();
        circularLinkedList.add("Apple");
        circularLinkedList.add("Banana");
        circularLinkedList.add("Orange");
        circularLinkedList.add("Mango");
        System.out.println("Circular Linked List: " + circularLinkedList);
    }
}

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

class CircularLinkedList<T> {
    private Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            Node<T> temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        do {
            sb.append(temp.getData()).append(" -> ");
            temp = temp.getNext();
        } while (temp != head);
        sb.append("(head)");
        return sb.toString();
    }
}
