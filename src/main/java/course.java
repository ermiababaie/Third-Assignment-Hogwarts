import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class course  {
    private UUID courseID;
    private String teacherName;
    private String courseName;
    private String details;
    List<String> students;
    HashMap<String,Double> studentScore;
    public course(String teacherName, String courseName, String details) {
        this.teacherName = teacherName;
        this.courseName = courseName;
        this.details = details;
        this.courseID = UUID.randomUUID();
        this.students = new ArrayList<>();
        studentScore = new HashMap<String,Double>();
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
    public void changeTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public String getCourseName() {
        return courseName;
    }
    public void scoring(String studentName, Double score) {
        studentScore.put(studentName, score);
    }
}