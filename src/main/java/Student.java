import java.util.*;

public class Student extends Account {
    Random rand = new Random();
    List<course> courses;
    static HashMap<UUID, Double> TeacherScore = new HashMap<>();
    List<Teacher> Teachers;
    String HogwartsSchool;
    String[] sch = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
    public Student(String username, String password) {
        super(username, password);
        HogwartsSchool = sch[rand.nextInt(4)];
        Teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }
    public void addCourse(course c) {
        courses.add(c);
        c.addStudent(getUsername());
        Teachers.add(c.getCourseTeacher());
//        for (int i = 0; i < Hogwarts.students.size(); i++) {
//            if (Hogwarts.students.get(i).getUsername().equals(getUsername())) {
//                Hogwarts.students.get(i).courses.remove(c);
//                Hogwarts.students.get(i).courses.add(c);
//            }
//        }
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