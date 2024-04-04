import java.util.*;

class Department {
    private String departmentCode;
    private String departmentName;
    private String building;
    private int yearFounded;

    public Department(String departmentCode, String departmentName, String building, int yearFounded) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.building = building;
        this.yearFounded = yearFounded;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getBuilding() {
        return building;
    }

    public int getYearFounded() {
        return yearFounded;
    }
}

class TeachingStaff {
    private int id;
    private String name;
    private String qualification;
    private Date dateOfJoining;
    private String departmentCode;

    public TeachingStaff(int id, String name, String qualification, Date dateOfJoining, String departmentCode) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.dateOfJoining = dateOfJoining;
        this.departmentCode = departmentCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }
}

class StudentDetails {
    private int studentId;
    private String name;
    private String mobileNumber;
    private String emailId;
    private String departmentCode;
    private int teacherCode;

    public StudentDetails(int studentId, String name, String mobileNumber, String emailId, String departmentCode,
            int teacherCode) {
        this.studentId = studentId;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.departmentCode = departmentCode;
        this.teacherCode = teacherCode;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public int getTeacherCode() {
        return teacherCode;
    }
}

class StudentMarks {
    private int studentId;
    private int semesterNumber;
    private int[] marks;

    public StudentMarks(int studentId, int semesterNumber, int[] marks) {
        this.studentId = studentId;
        this.semesterNumber = semesterNumber;
        this.marks = marks;
    }

    public int calculateTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double calculateAverageMarks() {
        return calculateTotalMarks() / (double) marks.length;
    }
}

public class College {
    public static void main(String[] args) {
        Department department1 = new Department("D001", "Computer Science", "Building A", 2000);
        Department department2 = new Department("D002", "Electrical Engineering", "Building B", 1995);

        TeachingStaff teacher1 = new TeachingStaff(101, "John Doe", "Ph.D.", new Date(), "D001");
        TeachingStaff teacher2 = new TeachingStaff(102, "Jane Smith", "M.Tech", new Date(), "D002");

        StudentDetails student1 = new StudentDetails(1001, "Alice", "1234567890", "alice@example.com", "D001", 101);
        StudentDetails student2 = new StudentDetails(1002, "Bob", "9876543210", "bob@example.com", "D002", 102);
        StudentDetails student3 = new StudentDetails(1003, "Charlie", "9876543210", "charlie@example.com", "D002", 103);
        StudentDetails student4 = new StudentDetails(1004, "Daniel", "9876543210", "daniel@example.com", "D001", 104);
        StudentDetails student5 = new StudentDetails(1005, "Elliot", "9876543210", "elliot@example.com", "D001", 105);

        System.out.println("DEPARTMENT DETAILS");
        System.out
                .println(department1.getDepartmentCode() + " " + department1.getDepartmentName() + " "
                        + department1.getBuilding() + " " +
                        department1.getYearFounded());
        System.out
                .println(department2.getDepartmentCode() + " " + department2.getDepartmentName() + " "
                        + department2.getBuilding() + " " +
                        department2.getYearFounded());

        System.out.println("\n\nTEACHER DETAILS");
        System.out.println(teacher1.getId() + " "
                + teacher1.getName() + " " + teacher1.getQualification() + " " +
                teacher1.getDateOfJoining() + " " + teacher1.getDepartmentCode());
        System.out.println(teacher2.getId() + " "
                + teacher2.getName() + " " + teacher2.getQualification() + " " +
                teacher2.getDateOfJoining() + " " + teacher2.getDepartmentCode());

        System.out.println("\n\nSTUDENT DETAILS");
        System.out.println(student1.getStudentId() + " " + student1.getName() + " " + student1.getMobileNumber() + " "
                + student1.getEmailId() + " " + student1.getDepartmentCode());
        System.out.println(student2.getStudentId() + " " + student2.getName() + " " + student2.getMobileNumber() + " "
                + student2.getEmailId() + " " + student2.getDepartmentCode());
        System.out.println(student3.getStudentId() + " " + student3.getName() + " " + student3.getMobileNumber() + " "
                + student3.getEmailId() + " " + student3.getDepartmentCode());
        System.out.println(student4.getStudentId() + " " + student4.getName() + " " + student4.getMobileNumber() + " "
                + student4.getEmailId() + " " + student4.getDepartmentCode());
        System.out.println(student5.getStudentId() + " " + student5.getName() + " " + student5.getMobileNumber() + " "
                + student5.getEmailId() + " " + student5.getDepartmentCode());

        int[] marks1 = { 85, 90, 75, 80 };
        int[] marks2 = { 70, 80, 65, 75 };
        int[] marks3 = { 90, 80, 60, 95 };
        int[] marks4 = { 50, 88, 69, 74 };
        int[] marks5 = { 70, 83, 85, 75 };
        StudentMarks studentMarks1 = new StudentMarks(1001, 1, marks1);
        StudentMarks studentMarks2 = new StudentMarks(1002, 1, marks2);
        StudentMarks studentMarks3 = new StudentMarks(1003, 1, marks3);
        StudentMarks studentMarks4 = new StudentMarks(1004, 1, marks4);
        StudentMarks studentMarks5 = new StudentMarks(1005, 1, marks5);

        System.out.println("\n\nSTUDENT MARKS DETAILS");
        System.out.println("Student 1 Details:");
        System.out.println("Total Marks: " + studentMarks1.calculateTotalMarks());
        System.out.println("Average Marks: " + studentMarks1.calculateAverageMarks());

        System.out.println("\nStudent 2 Details:");
        System.out.println("Total Marks: " + studentMarks2.calculateTotalMarks());
        System.out.println("Average Marks: " + studentMarks2.calculateAverageMarks());

        System.out.println("\nStudent 3 Details:");
        System.out.println("Total Marks: " + studentMarks3.calculateTotalMarks());
        System.out.println("Average Marks: " + studentMarks3.calculateAverageMarks());

        System.out.println("\nStudent 4 Details:");
        System.out.println("Total Marks: " + studentMarks4.calculateTotalMarks());
        System.out.println("Average Marks: " + studentMarks4.calculateAverageMarks());

        System.out.println("\nStudent 5 Details:");
        System.out.println("Total Marks: " + studentMarks5.calculateTotalMarks());
        System.out.println("Average Marks: " + studentMarks5.calculateAverageMarks());
    }
}
