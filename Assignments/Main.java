class Member {
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected String address;
    protected double salary;

    public Member(String name, int age, String phoneNumber, String address, double salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println("Salary: " + salary);
    }

    public static class Employee extends Member {
        String specialization;
        public Employee(String name, int age, String phoneNumber, String address, double salary,
                String specialization) {
            super(name, age, phoneNumber, address, salary);
            this.specialization = specialization;
        }
    }

    public static class Manager extends Member {
        String department;
        public Manager(String name, int age, String phoneNumber, String address, double salary, String department) {
            super(name, age, phoneNumber, address, salary);
            this.department = department;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Member.Employee employee = new Member.Employee("John Doe", 30, "1234567890", "123 Main St", 50000,
                "Software Engineering");
        Member.Manager manager = new Member.Manager("Jane Smith", 40, "0987654321", "456 Elm St", 80000,
                "Human Resources");

        System.out.println("Employee Details:");
        System.out.println("Name: " + employee.name);
        System.out.println("Age: " + employee.age);
        System.out.println("Phone Number: " + employee.phoneNumber);
        System.out.println("Address: " + employee.address);
        employee.printSalary();
        System.out.println("Specialization: " + employee.specialization);

        System.out.println("\nManager Details:");
        System.out.println("Name: " + manager.name);
        System.out.println("Age: " + manager.age);
        System.out.println("Phone Number: " + manager.phoneNumber);
        System.out.println("Address: " + manager.address);
        manager.printSalary();
        System.out.println("Department: " + manager.department);
    }
}
