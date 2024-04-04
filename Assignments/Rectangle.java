public class Rectangle {
    private int length;
    private int breadth;

    // Default constructor
    public Rectangle() {
        this.length = 10;
        this.breadth = 10;
    }

    // Parameterized constructor
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Getter methods
    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }

    // Main method
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(15, 20);

        System.out.println("Dimensions of rect1:");
        System.out.println("Length: " + rect1.getLength());
        System.out.println("Breadth: " + rect1.getBreadth());

        System.out.println("\nDimensions of rect2:");
        System.out.println("Length: " + rect2.getLength());
        System.out.println("Breadth: " + rect2.getBreadth());
    }
}
