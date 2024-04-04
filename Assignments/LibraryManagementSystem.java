import java.util.ArrayList;

public class LibraryManagementSystem {

    private static String[] allBooks;
    private ArrayList<LLNode> bookSeries;
    private ArrayList<DLLNode> overdueBooks;
    private ArrayList<CLLNode> waitlist;

    public static class LLNode {
        private String book;
        private LLNode next;

        public LLNode(String book) {
            this.book = book;
            this.next = null;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public LLNode getNext() {
            return next;
        }

        public void setNext(LLNode next) {
            this.next = next;
        }

        public void printList() {
            LLNode current = this;
            while (current != null) {
                System.out.println(current.getBook());
                current = current.getNext();
            }
            System.out.println("\n");
        }
    }

    public static class DLLNode {
        private String book;
        private DLLNode next;
        private DLLNode prev;
        private DLLNode head;

        public DLLNode() {
            this.head = null;
        }

        public DLLNode(String book, DLLNode next, DLLNode prev) {
            this.book = book;
            this.next = next;
            this.prev = prev;
        }

        public DLLNode getNext() {
            return next;
        }

        public void setNext(DLLNode next) {
            this.next = next;
        }

        public void setPrevious(DLLNode prev) {
            this.prev = prev;
        }

        public void printList() {
            DLLNode current = this;
            while (current != null) {
                System.out.println(current.book);
                current = current.next;
            }
            System.out.println("\n");
        }
    }

    public static class CLLNode {
        private String book;
        private CLLNode next;

        public CLLNode(String book) {
            this.book = book;
            this.next = null;
        }

        public String getBook() {
            return book;
        }

        public void setBook(String book) {
            this.book = book;
        }

        public CLLNode getNext() {
            return next;
        }

        public void setNext(CLLNode next) {
            this.next = next;
        }

        public void printList() {
            CLLNode current = this;
            if (current != null) {
                do {
                    System.out.println(current.getBook());
                    current = current.getNext();
                } while (current != this);
                System.out.println("\n");
            } else {
                System.out.println("Circular linked list is empty");
            }
        }
    }

    public static void main(String args[]) {

        // All Books
        allBooks = new String[] { "\"Harry Potter and the Sorcerer's Stone\" by J.K. Rowling",
                "\"The Hunger Games\" by Suzanne Collins", "\"Harry Potter and the Goblet of Fire\" by J.K. Rowling",
                "\"The Da Vinci Code\" by Dan Brown", "\"Harry Potter and the Half-Blood Prince\" by J.K. Rowling",
                "\"The Lord of the Rings\" by J.R.R. Tolkien" };

        System.out.println("All Books include:");
        for (String book : allBooks) {
            System.out.println(book);
        }
        System.out.println("\n" + "Number of Books in the Library are " + allBooks.length + "\n");

        // Overdue Books
        DLLNode node1 = new DLLNode(allBooks[1], null, null);
        DLLNode node2 = new DLLNode(allBooks[3], null, node1);
        DLLNode node3 = new DLLNode(allBooks[4], null, node2);
        DLLNode node4 = new DLLNode(allBooks[5], null, node3);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        System.out.println("Overdue Books are:");
        node1.printList();

        // Wait List
        CLLNode cl1 = new CLLNode(allBooks[0]);
        CLLNode cl2 = new CLLNode(allBooks[3]);
        CLLNode cl3 = new CLLNode(allBooks[5]);
        cl1.setNext(cl2);
        cl2.setNext(cl3);
        cl3.setNext(cl1);
        System.out.println("Wait List Books are:");
        cl1.printList();

        // Book Series
        LLNode ll1 = new LLNode(allBooks[0]);
        LLNode ll2 = new LLNode(allBooks[2]);
        LLNode ll3 = new LLNode(allBooks[4]);
        ll1.setNext(ll2);
        ll2.setNext(ll3);
        System.out.println("Book Series are:");
        ll1.printList();
    }
}
