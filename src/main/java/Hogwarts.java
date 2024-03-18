import java.util.List;

public class Hogwarts {

    List<Student> students;
    List<Teacher> teachers;
    List<course> courses;

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
        if (courseName.getTeacherName().equals("")) {
            courseName.changeTeacherName(teacher.getUsername());
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
