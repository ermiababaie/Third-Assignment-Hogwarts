/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("ErmiaHost", "ermia1384");
        Hogwarts.addAssistant(assistant);
        runMenu();
    }

    public static void AssistantMenu(Assistant assistant) {
        System.out.print("\n\n");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("choose one: (logOut, TeacherRequest, RemoveUser, CreateCourse, CheckProfile, ViewCourseDetail, Setting, newAssistant)");
            String input = in.next();
            while (!input.equals("logOut") && !input.equals("RemoveUser") && !input.equals("CreateCourse") && !input.equals("TeacherRequest")
                    && !input.equals("CheckProfile") && !input.equals("ViewCourseDetail") && !input.equals("Setting") && !input.equals("newAssistant")) {
                System.out.print("enter correct input: ");
                input = in.next();
            }
            if (input.equals("logOut")) {
                break;
            }
            else if (input.equals("newAssistant")) {
                while (true) {
                    System.out.print("enter username: ");
                    input = in.next();
                    boolean find = false;
                    for (int i = 0; i < Hogwarts.Assistants.size(); i++) {
                        find |= Hogwarts.Assistants.get(i).getUsername().equals(input);
                    }
                    if (find) {
                        System.out.println("UserName already exist!");
                    }
                    else {
                        break;
                    }
                }
                System.out.print("enter PassWord: ");
                String pass = in.next();
                Assistant newAssistant = new Assistant(input, pass);
                Hogwarts.Assistants.add(newAssistant);
            }
            else if (input.equals("RemoveUser")) {
                System.out.print("teacher ot student? ");
                input = in.next();
                while (!input.equals("teacher") && !input.equals("student")) {
                    System.out.print("enter correct input: ");
                    input = in.next();
                }
                if (input.equals("teacher")) {
                    Hogwarts.viewAllTeachers();
                    System.out.print("\n" + "enter teacher name: ");
                    String name = in.next();
                    boolean find = false;
                    while (true) {
                        name = in.next();
                        if (name.equals("back-to-menu"))
                            break;
                        for (int i = 0; i < Hogwarts.teachers.size(); i++) {
                            find |= Hogwarts.teachers.get(i).getUsername().equals(name);
                        }
                        if (find)
                            break;
                        else {
                            System.out.println("enter correct input");
                        }
                    }
                    if (find) {
                        Teacher teacher = new Teacher("", "");
                        Teacher teacher2 = new Teacher("", "");
                        for (int i = 0; i < Hogwarts.teachers.size(); i++) {
                            if (Hogwarts.teachers.get(i).getUsername().equals(name)) {
                                teacher = Hogwarts.teachers.get(i);
                            }
                        }
                        Hogwarts.teachers.remove(teacher);
                        for (int i = 0; i < teacher.courses.size(); i++) {
                            teacher.courses.get(i).changeTeacher(teacher2);
                        }
                        for (int i = 0; i < Hogwarts.courses.size(); i++) {
                            if (Hogwarts.courses.get(i).courseTeacher.equals(teacher)) {
                                Hogwarts.courses.get(i).changeTeacher(teacher2);
                            }
                        }
                        for (int i = 0; i < Hogwarts.students.size(); i++) {
                            for (int j = 0; j < Hogwarts.students.get(i).courses.size(); j++) {
                                if (Hogwarts.students.get(i).courses.get(j).courseTeacher.equals(teacher)) {
                                    Hogwarts.students.get(i).courses.get(j).changeTeacher(teacher2);
                                }

                            }
                        }
                    }

                }
                else {
                    Hogwarts.viewAllStudents();
                    System.out.print("\n" + "enter student name: ");
                    String name = in.next();
                    boolean find = false;
                    while (true) {
                        name = in.next();
                        if (name.equals("back-to-menu"))
                            break;
                        for (int i = 0; i < Hogwarts.students.size(); i++) {
                            find |= Hogwarts.students.get(i).getUsername().equals(name);
                        }
                        if (find)
                            break;
                        else {
                            System.out.println("enter correct input");
                        }
                    }
                    if (find) {
                        Student student = new Student("", "");
                        Student student2 = new Student("", "");
                        for (int i = 0; i < Hogwarts.students.size(); i++) {
                            if (Hogwarts.students.get(i).getUsername().equals(name)) {
                                student = Hogwarts.students.get(i);
                            }
                        }
                        Hogwarts.students.remove(student);
                        for (int i = 0; i < student.courses.size(); i++) {
                            student.courses.get(i).students.remove(name);
                        }
                        for (int i = 0; i < Hogwarts.courses.size(); i++) {
                            Hogwarts.courses.get(i).students.remove(name);
                        }
                        for (int i = 0; i < Hogwarts.teachers.size(); i++) {
                            for (int j = 0; j < Hogwarts.teachers.get(i).courses.size(); j++) {
                                Hogwarts.teachers.get(i).courses.get(j).students.remove(name);
                            }
                        }
                    }
                }
            }
            else if (input.equals("TeacherRequest")) {
                assistant.teacherRegister();
            }
            else if (input.equals("CreateCourse")) {
                System.out.print("enter name for course: ");
                input = in.next();
                System.out.print("enter course details: ");
                String det = "";
                while (in.hasNext()) {
                    String input2 = in.next();
                    if (input2.equals("FINISH")) {
                        break;
                    }
                    det += input2 + ' ';
                }
                Teacher teacher = new Teacher("", "");
                course course = new course(teacher, input, det);
                Hogwarts.courses.add(course);
            }
            else if (input.equals("CheckProfile")) {
                System.out.println("Select profile with ID: ");
                for (int i = 0; i < Hogwarts.students.size(); i++) {
                    System.out.println((i + 1) + " : " + Hogwarts.students.get(i).getUsername());
                }
                for (int i = 0; i < Hogwarts.teachers.size(); i++) {
                    System.out.println((i + Hogwarts.students.size() + 1) + " : " + Hogwarts.teachers.get(i).getUsername());
                }
                int num = in.nextInt();
                if (num > Hogwarts.students.size()) {
                    System.out.println("userName : " + Hogwarts.teachers.get(num - Hogwarts.students.size() - 1).getUsername());
//                    System.out.println("PassWOrd : " + Hogwarts.students.get(num - Hogwarts.students.size() - 1).());
                   System.out.println("Courses : ");
                   System.out.print("\t");
                    for (int i = 0; i < Hogwarts.teachers.get(num - Hogwarts.students.size() - 1).courses.size(); i++) {
                        course course = Hogwarts.teachers.get(num - Hogwarts.students.size() - 1).courses.get(i);
                        System.out.println(course.getCourseName() + " :");
                        for (int j = 0; j < course.getStudents().size(); j++) {
                            System.out.print(course.getStudents().get(j) + " - ");
                        }
                    }
                    System.out.print("\n");
                    Hogwarts.teachers.get(num - Hogwarts.students.size() - 1).getTeacherScore();
                    System.out.print("\n");
                }
                else {
                    System.out.println("userName : " + Hogwarts.teachers.get(num - 1).getUsername());
//                    System.out.println("PassWOrd : " + Hogwarts.students.get(num - Hogwarts.students.size() - 1).());
                    System.out.println("Courses : ");
                    System.out.print("\t");
                    for (int i = 0; i < Hogwarts.students.get(num - 1).courses.size(); i++) {
                        course course = Hogwarts.students.get(num - 1).courses.get(i);
                        System.out.print(course.getCourseName() + " With " + course.courseTeacher.getUsername() + ", score: ");
                        System.out.println(course.studentScore.get(Hogwarts.students.get(num - 1).getUsername()));
                    }
                }
            }
            else if (input.equals("ViewCourseDetail")) {
                for (int i = 0; i < Hogwarts.courses.size(); i++) {
                    course course = Hogwarts.courses.get(i);
                    System.out.println(course.getCourseName() + " : ");
                    System.out.println("\t" + course.getDetails() + "  " + course.courseTeacher.getUsername());
                    System.out.print("\t\t");
                    for (int j = 0; j < course.getStudents().size(); j++) {
                        System.out.print(course.getStudents().get(j) + " - ");
                    }
                    System.out.print("\n");
                }
            }
            else {
                System.out.print("choos one : (changePass, changeUserName :");
                input = in.next();
                while (!input.equals("changePass") && !input.equals("changeUserName")) {
                    System.out.print("enter correct input: ");
                    input = in.next();
                }
                if (input.equals("changePass")) {
                    System.out.print("enter new password: ");
                    input = in.next();
                    assistant.changePassword(input);
                }
                else {
                    while (true) {
                        System.out.print("enter new userName: ");
                        input = in.next();
                        if (!input.equals(assistant.getUsername())) {
                            boolean find = false;
                            for (int i = 0; i < Hogwarts.Assistants.size(); i++)
                                find |= Hogwarts.Assistants.get(i).getUsername().equals(input);
                            if (!find)
                                break;
                        }
                    }
                    assistant.changeUsername(input);
                }
            }
        }
    }
     public static void TeacherMenu(Teacher teacher) {
        System.out.print("\n\n");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("choose one: (logOut, CourseRequest, MyCourses, Scoring, MyScore, Setting)");
            String input = in.next();
            while (!input.equals("logOut") && !input.equals("CourseRequest") && !input.equals("MyCourses")
                    && !input.equals("Scoring") && !input.equals("MyScore") && !input.equals("Setting") ) {
                System.out.print("enter correct input: ");
                input = in.next();
            }
            if (input.equals("logOut")) {
                break;
            }
            else if (input.equals("CourseRequest")) {
                Hogwarts.courseRequest(teacher);
            }
            else if (input.equals("MyCourses")) {
                teacher.getStudent();
            }
            else if (input.equals("MyScore")) {
                teacher.getTeacherScore();
            }
            else if (input.equals("Scoring")) {
                Hogwarts.Scoring(teacher);
            }
            else {
                System.out.print("choos one : (changePass, changeUserName :");
                input = in.next();
                while (!input.equals("changePass") && !input.equals("changeUserName")) {
                    System.out.print("enter correct input: ");
                    input = in.next();
                }
                if (input.equals("changePass")) {
                    System.out.print("enter new password: ");
                    input = in.next();
                    teacher.changePassword(input);
                }
                else {
                    while (true) {
                        System.out.print("enter new userName: ");
                        input = in.next();
                        if (!input.equals(teacher.getUsername())) {
                            boolean find = false;
                            for (int i = 0; i < Hogwarts.teachers.size(); i++)
                                find |= Hogwarts.teachers.get(i).getUsername().equals(input);
                            if (!find)
                                break;
                        }
                    }
                    String lastUserName = teacher.getUsername();
                    teacher.changeUsername(input);
                    for (int i = 0; i < Hogwarts.teachers.size(); i++) {
                        if (Hogwarts.teachers.get(i).getAccountID().equals(teacher.getAccountID())) {
                            Hogwarts.teachers.get(i).changeUsername(input);
                        }
                    }
                    for (int i = 0; i < Hogwarts.courses.size(); i++) {
                        if (Hogwarts.courses.get(i).getCourseTeacher().getAccountID().equals(teacher.getAccountID())) {
                            Hogwarts.courses.get(i).changeTeacher(teacher);
                        }
                    }
                    for (int i = 0; i < Hogwarts.students.size(); i++) {
                        Student student = Hogwarts.students.get(i);
                        for (int j = 0; j < student.getTeachers().size(); j++) {
                            if (student.getTeachers().get(j).getAccountID().equals(teacher.getAccountID()))
                                    student.getTeachers().get(j).changeUsername(input);
                        }
                        for (int j = 0; j < student.courses.size(); j++) {
                            if (student.courses.get(j).getCourseTeacher().getAccountID().equals(teacher.getAccountID())) {
                                student.courses.get(j).changeTeacher(teacher);
                            }
                        }
                    }
                    for (int i = 0; i < Assistant.teachersInQueue.size(); i++) {
                       if  (Assistant.teachersInQueue.get(i).getUsername().equals(lastUserName)) {
                           Assistant.teachersInQueue.get(i).changeUsername(input);
                       }
                    }

                }
            }
        }
    }
    public static void StudentMenu(Student student) {
        System.out.print("\n\n");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("choose one: (logOut, TakeCourse, MyCourses, MyTeachers, ScoreTeachers, Setting)");
            String input = in.next();
            while (!input.equals("logOut") && !input.equals("TakeCourse") && !input.equals("MyCourses")
                    && !input.equals("MyTeachers") && !input.equals("ScoreTeachers") && !input.equals("Setting") ) {
                System.out.print("enter correct input: ");
                input = in.next();
            }
            if (input.equals("logOut")) {
                break;
            }
            else if (input.equals("TakeCourse")) {
                for (int i = 0; i < Hogwarts.courses.size(); i++) {
                    course course = Hogwarts.courses.get(i);
                    System.out.println(i + " : " + course.getCourseName() + " - " + course.getCourseTeacher().getUsername() + " - " + course.getCourseID());
                }
                System.out.print("Enter number of course you want: ");
                int input2 = in.nextInt();
                if (input2 >= Hogwarts.courses.size()) {
                    System.out.println("Access denied!");
                }
                else {
                    course course = Hogwarts.courses.get(input2);
                    boolean find = false;
                    for (int i = 0; i < student.courses.size(); i++) {
                        if (student.courses.get(i).getCourseID().equals(course.getCourseID())) {
                            find = true;
                        }
                    }
                    if (find) {
                        System.out.println("course has already exist.");
                    }
                    else {
                        student.addCourse(course);
                    }
                }
            }
            else if (input.equals("MyCourses")) {
                for (int i = 0; i < student.getCourses().size(); i++) {
                    System.out.print(student.getCourses().get(i).getCourseName() + " ");
                }
                System.out.print("\n");
            }
            else if (input.equals("MyTeachers")) {
                for (int i = 0; i < student.getTeachers().size(); i++) {
                    System.out.print(student.getTeachers().get(i).getUsername() + " ");
                }
                System.out.print("\n");
            }
            else if (input.equals("ScoreTeachers")) {
                System.out.println("select course for score teacher: ");
                for (int i = 0; i < student.courses.size(); i++) {
                    course course = student.courses.get(i);
                    System.out.println(i + " : " + course.getCourseName() + " - " + course.getCourseTeacher().getUsername() + " - " + course.getCourseID());
                }
                System.out.print("Enter number of course you want: ");
                int input2 = in.nextInt();
                if (input2 >= student.courses.size()) {
                    System.out.println("number not exist!");
                }
                else {
                    course course = student.courses.get(input2);
                    if (student.TeacherScore.get(course.getCourseID()) == null) {
                        System.out.print("enter Score: ");
                        Double score = in.nextDouble();
                        student.scoreTeacher(course.getCourseID(), score);
                    }
                    else {
                        System.out.println("you have already scored this teacher");
                    }
                }
            }
            else {
                System.out.print("choos one : (changePass, changeUserName :");
                input = in.next();
                while (!input.equals("changePass") && !input.equals("changeUserName")) {
                    System.out.print("enter correct input: ");
                    input = in.next();
                }
                if (input.equals("changePass")) {
                    System.out.print("enter new password: ");
                    input = in.next();
                    student.changePassword(input);
                }
                else {
                    String lastUserName = student.getUsername();
                    while (true) {
                        System.out.print("enter new userName: ");
                        input = in.next();
                        if (!input.equals(student.getUsername())) {
                            boolean find = false;
                            for (int i = 0; i < Hogwarts.students.size(); i++)
                                find |= Hogwarts.students.get(i).getUsername().equals(input);
                            if (!find)
                                break;
                        }
                    }
                    input = in.next();
                    student.changeUsername(input);
                    for (int i = 0; i < Hogwarts.courses.size(); i++) {
                        course course = Hogwarts.courses.get(i);
                        for (int j = 0; j < course.getStudents().size(); j++) {
                            if (course.getStudents().get(j).equals(lastUserName))
                                course.getStudents().get(j).equals(input);
                        }
                        course.studentScore.put(lastUserName, course.studentScore.get(lastUserName));
                        course.studentScore.remove(lastUserName);
                    }
                }
            }
        }
    }
    public static void runMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("enter back-to-menu for going yo menu");
            System.out.println("select your profile: (student, teacher, assistant)");
            String input = in.next();
            while (!input.equals("student") && !input.equals("teacher") && !input.equals("assistant")) {
                System.out.print("enter correct input : ");
                input = in.next();
            }
            //Student
            if (input.equals("student")) {
                System.out.println("signup or login?");
                input = in.next();
                while (!input.equals("signup") && !input.equals("login") && !input.equals("back-to-menu")) {
                    System.out.print("enter correct input : ");
                    input = in.next();
                }
                if (input.equals("signup")) {
                    while (true) {
                        System.out.print("enter userName: ");
                        input = in.next();
                        boolean find = false;
                        for (int i = 0; i < Hogwarts.students.size(); i++) {
                            find |= Hogwarts.students.get(i).getUsername().equals(input);
                        }
                        if (find) {
                            System.out.println("username already exist!");
                        }
                        else {
                            System.out.print("enter passWord: ");
                            String pass = in.next();
                            Student student = new Student(input, pass);
                            Hogwarts.students.add(student);
                            break;
                        }
                    }
                }
                else if (input.equals("login")) {
                    while (true) {
                        System.out.print("enter userName: ");
                        input = in.next();
                        if (input.equals("back-to-menu"))
                            break;
                        boolean find = false;
                        Student student = new Student("", "");
                        for (int i = 0; i < Hogwarts.students.size(); i++) {
                            if (Hogwarts.students.get(i).getUsername().equals(input)) {
                                student = Hogwarts.students.get(i);
                            }
                            find |= Hogwarts.students.get(i).getUsername().equals(input);
                        }
                        if (!find) {
                            System.out.println("username not found!");
                        }
                        else {
                            while (true) {
                                System.out.print("enter passWord: ");
                                String pass = in.next();
                                if (pass.equals("back-to-menu"))
                                    break;
                                if (student.validatePassword(pass)) {
                                    StudentMenu(student);
                                    break;
                                }
                                else {
                                    System.out.println("incorrect password!");
                                }
                            }
                            break;
                        }
                    }
                }
            }
            //teacher
            else if (input.equals("teacher")) {
                System.out.println("signup or login?");
                input = in.next();
                while (!input.equals("signup") && !input.equals("login") && !input.equals("back-to-menu")) {
                    System.out.print("enter correct input : ");
                    input = in.next();
                }
                if (input.equals("signup")) {
                    while (true) {
                        System.out.print("enter userName: ");
                        input = in.next();
                        boolean find = false;
                        for (int i = 0; i < Hogwarts.teachers.size(); i++) {
                            find |= Hogwarts.teachers.get(i).getUsername().equals(input);
                        }
                        if (find) {
                            System.out.println("username already exist!");
                        }
                        else {
                            System.out.print("enter passWord: ");
                            String pass = in.next();
                            Teacher newTeacher = new Teacher(input, "kalampoloshirzi+salad+khoonezahraina");
                            newTeacher.setPass(pass);
                            Hogwarts.teachers.add(newTeacher);
                            Assistant.teachersInQueue.add(newTeacher);
                            System.out.println("please wait to verify your access.");
                            break;
                        }
                    }
                }
                else if (input.equals("login")) {
                    while (true) {
                        System.out.print("enter userName: ");
                        input = in.next();
                        if (input.equals("back-to-menu"))
                            break;
                        boolean find = false;
                        Teacher teacher = new Teacher("", "");
                        for (int i = 0; i < Hogwarts.teachers.size(); i++) {
                            if (Hogwarts.teachers.get(i).getUsername().equals(input)) {
                                teacher = Hogwarts.teachers.get(i);
                            }
                            find |= Hogwarts.teachers.get(i).getUsername().equals(input);
                        }
                        if (!find) {
                            System.out.println("username not found!");
                        }
                        else {
                            while (true) {
                                System.out.print("enter passWord: ");
                                String pass = in.next();
                                if (pass.equals("back-to-menu"))
                                    break;
                                if (teacher.validatePassword(pass)) {
                                    TeacherMenu(teacher);
                                    break;
                                }
                                else {
                                    System.out.println("incorrect password!");
                                }
                            }
                            break;
                        }
                    }
                }
            }
            else {
                while (true) {
                    System.out.print("enter userName: ");
                    input = in.next();
                    if (input.equals("back-to-menu"))
                        break;
                    boolean find = false;
                    Assistant assistant = new Assistant("", "");
                    for (int i = 0; i < Hogwarts.Assistants.size(); i++) {
                        if (Hogwarts.Assistants.get(i).getUsername().equals(input)) {
                            assistant = Hogwarts.Assistants.get(i);
                        }
                        find |= Hogwarts.Assistants.get(i).getUsername().equals(input);
                    }
                    if (!find) {
                        System.out.println("username not found!");
                    }
                    else {
                        while (true) {
                            System.out.print("enter passWord: ");
                            String pass = in.next();
                            if (pass.equals("back-to-menu"))
                                break;
                            if (assistant.validatePassword(pass)) {
                                AssistantMenu(assistant);
                                break;
                            }
                            else {
                                System.out.println("incorrect password!");
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
