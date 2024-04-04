interface Shape {
    double calculateArea();
    void displayShapeInfo();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayShapeInfo() {
        System.out.println("Circle with radius: " + radius);
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void displayShapeInfo() {
        System.out.println("Rectangle with length: " + length + " and width: " + width);
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        circle.displayShapeInfo();
        System.out.println("Area of the circle: " + circle.calculateArea());
        System.out.println();
        rectangle.displayShapeInfo();
        System.out.println("Area of the rectangle: " + rectangle.calculateArea());
    }
}
