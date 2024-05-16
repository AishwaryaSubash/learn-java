import java.util.ArrayList;
import java.util.List;

public class Course {
    private Integer courseId;
    private String courseName;
    private Double courseFee;
    private Integer duration;

    public Course(Integer courseId, String courseName, Double courseFee, Integer duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.duration = duration;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Double courseFee) {
        this.courseFee = courseFee;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                ", duration=" + duration +
                '}';
    }

    public static void main(String[] args) {
        CourseData courseData = CourseData.getInstance();
        for (Course course : courseData.getCourseList()) {
            System.out.println(course);
        }
    }
}

class CourseData implements Cloneable {
    private static List<Course> courseList = new ArrayList<>();
    private static CourseData instance;

    static {
        courseList.add(new Course(101, "BTech", 450000.00, 48));
        courseList.add(new Course(202, "MTech", 405000.00, 24));
        courseList.add(new Course(303, "BCA", 425000.00, 48));
        courseList.add(new Course(404, "MCA", 450000.00, 24));
    }

    private CourseData() {
    }

    public static CourseData getInstance() {
        if (instance == null) {
            synchronized (CourseData.class) {
                if (instance == null) {
                    instance = new CourseData();
                }
            }
        }
        return instance;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this object is not allowed.");
    }

    protected Object readResolve() {
        return getInstance();
    }

}
