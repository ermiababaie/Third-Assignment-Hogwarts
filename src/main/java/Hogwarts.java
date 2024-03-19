import java.util.ArrayList;
import java.util.List;

public class Hogwarts {

    static List<Assistant> Assistants = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();
    static List<course> courses = new ArrayList<>();

    public static void addAssistant(Assistant assistant) {
        Assistants.add(assistant);
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
    public void addCourse(course courseName) {
        courses.add(courseName);
    }

    public void courseReq(Teacher teacher, course courseName) {
        if (courseName.getCourseTeacher().getUsername().equals("")) {
            courseName.courseTeacher.changeUsername(teacher.getUsername());
        }
        else {
            System.out.println("access denied");
        }
    }

    public void viewAllTeachers() {
        //TODO
    }

    public void viewAllStudents() {
        //TODO
    }

    public void viewAllCourses() {
        //TODO
    }
}
