import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Assistant extends Account {
    static List<course> allCourses = new ArrayList<>();
   public Assistant(String username, String password) {
       super(username, password);
   }
   public void getCoursesAndStudents(List<course> allCourses) {
       for (int i = 0; i < allCourses.size(); i++){
           System.out.println(allCourses.get(i).getCourseName() + " :");
           System.out.println("\t" + allCourses.get(i).getStudents());
       }
   }
   public void addCourse(course c) {
        allCourses.add(c);
   }
   public void makeCourse(String courseName, String details) {
       course c = new course("", courseName, details);
       addCourse(c);
   }
   public static List<String> getCoursesName() {
       List<String> coursesName = new ArrayList<>();
       for (int i = 0; i < allCourses.size(); i++) {
           coursesName.add(allCourses.get(i).getCourseName());
       }
       return coursesName;
   }
}