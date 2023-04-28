package Controller;

import Model.Student;
import Util.FileName;
import Util.SerializationUtil;
import java.util.ArrayList;

public class StudentController implements Controller {

    ArrayList<Student> students;
    private static StudentController studentController;

    public static StudentController ActivateStudentController() {
        if (StudentController.studentController == null) {
            StudentController.studentController = new StudentController();
        }
        return StudentController.studentController;
    }

    StudentController() {
        this.students = new ArrayList<>();
        students = (ArrayList<Student>) SerializationUtil.readObjectFromFile(FileName.STUDENT);
    }

    @Override
    public int getNewID() {
        return students.size() + 1;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(student -> student.getStudentID() == id)
                .findFirst()
                .orElse(null);
    }

    public Student getStudentByUsername(String userName) {
        return students.stream()
                .filter(student -> (student.getUsername() == null ? userName == null : student.getUsername().equals(userName)))
                .findFirst()
                .orElse(null);
    }

    public void addStudent(Student student) {
        this.students.add(student);
        saveRecords();
    }

    public void updateStudent(Student stu) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID() == stu.getStudentID()) {
                students.set(i, stu);
                break;
            }
        }
        saveRecords();
    }

    @Override
    public void saveRecords() {
        SerializationUtil.writeObjectToFile(this.students, FileName.STUDENT);
    }

    // Testing
//    public static void main(String[] args) {
//        StudentController sc = StudentController.ActivateStudentController();
//        sc.getStudents().forEach(student -> {
//            System.out.println(student.getName());
//        });
//        
////        System.out.println(sc.getNewID());
//        System.out.println(sc.getStudentById(1));
//        System.out.println(sc.getStudentByUsername("cindy223"));
////        sc.addStudent(new Student(2, "stu2", "", "", "",4.0,"",""));
////        sc.updateStudent(new Student(2, "halo", "", "", "",4.0,"",""));
////        System.out.println(sc.getStudentById(2));
//    }
}
