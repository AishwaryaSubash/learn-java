abstract class Shape {
    // Abstract method
    public abstract double calculateArea();

    public void display() {
        System.out.println("This is a shape");
    }
}

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(7);
        double area = circle.calculateArea();
        System.out.println("Area of circle: " + area);
        circle.display();
    }
}
