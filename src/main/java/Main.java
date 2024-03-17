/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student anita = new Student("anita", "123456");
        course riazi1 = new course("hajJabbari", "riazi1");
        course riazi2 = new course("bijhan", "riazi2");
        anita.addCourse(riazi1);
        anita.addCourse(riazi2);
    }

    public static void runMenu() {
        // TODO: Menu will be shown here...
    }
}
