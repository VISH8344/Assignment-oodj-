/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Student;
import Util.FileName;
import Util.SerializationUtil;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 */
public class StudentController implements Controller {
     ArrayList<Student> students;
    
    private static StudentController studentController;
    
    public static StudentController ActivateStudentController(){
        if(StudentController.studentController == null){
            StudentController.studentController = new StudentController();
        }
        return StudentController.studentController;
    }
    
    StudentController(){
        this. students = new ArrayList<>();
        students = (ArrayList<Student>) SerializationUtil.readObjectFromFile(FileName.STUDENT);
    }
    
     @Override
    public int getNewID(){
        return students.size()+1;
    }
    
    public ArrayList<Student> getStudents(){
        return this.students;
    }
    
    public Student getStudentById(int id){
        return students.stream()
                .filter(student -> student.getStudentID() == id)
                .findFirst()
                .orElse(null);
    }
    
    public Student getStudentByUsername(String newUsername) {
        Student found = null;
        for (int i = 0; i < students.size(); i++) {
            Student c = students.get(i);
            if (newUsername.equals(c.getUsername())) {
                found = c;
                break;
            }
        }
        return found;
    }
    
    public void addStudent(Student student){
        this.students.add(student);
        saveRecords();
    }
    
    public void updateStudent(Student stu){
        this.students.stream()
                .map(student -> student.getStudentID()== stu.getStudentID() ? stu : student)
                .collect(Collectors.toList());
        saveRecords();
    }
    
     @Override
    public void saveRecords(){
        this.students.stream()
                .forEach(student -> SerializationUtil.writeObjectToFile(student, FileName.STUDENT));
    }
}
