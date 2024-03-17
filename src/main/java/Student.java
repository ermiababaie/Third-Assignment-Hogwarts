import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student extends Account {
    List<course> courses;
    //codeman
    public Student(String username, String password) {
        super(username, password);
        courses = new ArrayList<>();
    }
    public void addCourse(course c) {
        courses.add(c);
        c.addStudent(getUsername());
    }
    public List<course> getCourses() {
        return courses;
    }
    public List<String> getTeachers() {
        List<String> Teachers = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            Teachers.add(courses.get(i).getTeacherName());
        }
        return Teachers;
    }

}