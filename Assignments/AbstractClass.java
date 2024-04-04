abstract class Shape {
    // Abstract method
    public abstract double calculateArea();

    // Non-abstract method
    public void display() {
        System.out.println("This is a shape");
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementation of abstract method
    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 6);
        double area = rectangle.calculateArea();
        System.out.println("Area of rectangle: " + area);
        rectangle.display();
    }
}
