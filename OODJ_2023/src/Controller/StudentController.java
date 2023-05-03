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

    private int generateUniqueNumber(int num){
        return num + 1;
    }
    
    private boolean checkIDIsExist(int id){
        boolean isFound = false;
        for(Student stu : students){
            if(stu.getStudentID()== id){
                isFound = true;
            }
        }
        return isFound;
    }

    @Override
    public int getNewID() {
        int tempNewId = students.size() + 1;
        boolean isIDExist = checkIDIsExist(tempNewId);
        while(isIDExist){
            tempNewId = generateUniqueNumber(tempNewId);
            if(!checkIDIsExist(tempNewId)){
                break;
            }
        }
        return tempNewId;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public Student getStudentById(int id) {
        Student response = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID()== id) {
                response = students.get(i);
                break;
            }
        }
        if (response == null) {
                System.out.println("Student with this id : " + id + " is not found");
        }
        return response;
    }

    public Student getStudentByUsername(String userName) {
        Student response = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUsername() == null ? userName == null : students.get(i).getUsername().equals(userName)) {
                response = students.get(i);
                break;
            }
        }
        if (response == null) {
                System.out.println("Student with this username : " + userName + " is not found");
        }
        return response;
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
