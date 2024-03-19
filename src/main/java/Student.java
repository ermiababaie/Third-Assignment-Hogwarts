import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Student extends Account {
    List<course> courses;
    static HashMap<UUID, Double> TeacherScore = new HashMap<>();
    List<Teacher> Teachers;
    public Student(String username, String password) {
        super(username, password);
        Teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }
    public void addCourse(course c) {
        courses.add(c);
        c.addStudent(getUsername());
        Teachers.add(c.getCourseTeacher());
    }
    public List<course> getCourses() {
        return courses;
    }
    public List<Teacher> getTeachers() {
        return Teachers;
    }
    public void scoreTeacher(UUID uuid, Double teacherScore) {
        this.scoreTeacher(uuid, teacherScore);
    }
}