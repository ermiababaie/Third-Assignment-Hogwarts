/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student anita = new Student("anita", "123456");
        course riazi1 = new course("hajJabbari", "riazi1", "");
        Assistant.allCourses.add(riazi1);
        course riazi2 = new course("bijhan", "riazi2", "");
        Assistant.allCourses.add(riazi2);
        course ap = new course("", "ap", "");
        Assistant.allCourses.add(ap);
        anita.addCourse(riazi1);
        anita.addCourse(riazi2);
        Teacher kherad = new Teacher("kheradpishe", "12345ijklfdmflkdj");
        kherad.addCourse(ap);
        anita.addCourse(ap);
        Student fateme = new Student("fateme", "mjkfnkldsfjkfdngkflks");
        fateme.addCourse(ap);
        Assistant masoom = new Assistant("masoom", "123");
        masoom.makeCourse("narmafzar2", "python");
        Teacher maryamB = new Teacher("mary", "afzal");
        System.out.println(Assistant.getCoursesName());
        Scanner in = new Scanner(System.in);
        String courseName = in.next();
        maryamB.addCourse(courseName, Assistant.allCourses);
        masoom.getCoursesAndStudents(Assistant.allCourses);
    }

    public static void runMenu() {
        // TODO: Menu will be shown here...
    }
}
