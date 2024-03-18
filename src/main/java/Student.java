import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student extends Account {
    List<course> courses;
    List<String> Teachers;
    public Student(String username, String password) {
        super(username, password);
        Teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }
    public void addCourse(course c) {
        courses.add(c);
        c.addStudent(getUsername());
        Teachers.add(c.getTeacherName());
    }
    public List<course> getCourses() {
        return courses;
    }
    public List<String> getTeachers() {
        return Teachers;
    }
}