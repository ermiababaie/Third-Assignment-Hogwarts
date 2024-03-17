import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Account {
    List<course> courses;
    List<Double> teacherScores;
    public Teacher(String username, String password) {
        super(username, password);
        courses = new ArrayList<>();
    }
    public void addCourse(course c) {
        courses.add(c);
        c.changeTeacherName(getUsername());
    }
    public void addCourse(String coursename, List<course> allCourses) {
        for (int i = 0; i < allCourses.size(); i++) {
            if (allCourses.get(i).getCourseName().equals(coursename)) {
                addCourse(allCourses.get(i));
            }
        }
    }
    public void scoring() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).getCourseName() + ", ");
        }
        System.out.print("\nenter course name: ");
        String courseName = in.next();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseName)) {
                System.out.println(courses.get(i).getStudents());
                System.out.print("enter score of students: ");
                for (int j = 0; j < courses.get(i).getStudents().size(); j++) {
                    String studentName = courses.get(i).getStudents().get(j);
                    Double score = in.nextDouble();
                    courses.get(i).scoring(studentName, score);
                }
            }
        }
    }
    public void getStudent() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).getCourseName() + ", ");
        }
        System.out.print("\nenter course name: ");
        String courseName = in.next();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseName().equals(courseName)) {
                System.out.println(courses.get(i).getStudents());
            }
        }
    }

    public void getCourses() {
        for (int i = 0; i < courses.size(); i++) {
            System.out.print(courses.get(i).getCourseName() + ", ");
        }
        System.out.print("\n");
    }
    public void addTeacherScore(Double TeacherScore) {
        this.teacherScores.add(TeacherScore);
    }
    public Double getTeacherScore() {
        Double TeacherScore = 0.0;
        Double cnt = (double)teacherScores.size();
        for (int i = 0; i < teacherScores.size(); i++) {
            TeacherScore += teacherScores.get(i);
        }
        return TeacherScore / cnt;
    }
}