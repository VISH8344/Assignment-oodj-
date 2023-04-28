package Model;

import java.io.Serializable;

public class Student extends User implements Serializable{
    private int studentID;
    private String name;
    private String NIC;
    private String address;
    private String gender;
    private double balance;

    public Student(int studentID, String name, String NIC, String address, String gender, double balance, String username, String password) {
        super(username, password);
        this.studentID = studentID;
        this.name = name;
        this.NIC = NIC;
        this.address = address;
        this.gender = gender;
        this.balance = balance;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", NIC=" + NIC + ", address=" + address + ", gender=" + gender + ", balance=" + balance + ", username: "+ super.getUsername() +'}';
    }
    
}
