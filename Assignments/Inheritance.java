class Vehicle {
    private String make;
    private String model;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Starting the engine of the vehicle...");
    }
}

class Car extends Vehicle {
    public Car(String make, String model) {
        super(make, model);
    }

    @Override
    public void startEngine() {
        System.out.println("Starting the engine of the car...");
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model) {
        super(make, model);
    }

    @Override
    public void startEngine() {
        System.out.println("Starting the engine of the motorcycle...");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Camry");
        Vehicle motorcycle = new Motorcycle("Honda", "CBR");
        car.startEngine();
        motorcycle.startEngine();
    }
}
