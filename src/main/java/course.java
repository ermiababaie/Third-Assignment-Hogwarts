import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class course  {
    private UUID courseID;
    private String teacherName;
    private String courseName;
    List<String> students;
    public course(String teacherName, String courseName) {
        this.teacherName = teacherName;
        this.courseName = courseName;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
    }

    public void addStudent(String student) {
        this.students.add(student);
    }
    public List<String> getStudents() {
        return students;
    }
    public String getTeacherName() {
        return teacherName;
    }

}