package Model;

import java.io.Serializable;

public class Student extends User implements Serializable{

    private String name;
    private int NIC;
    private String address;
    private String gender;
    private double balance;

    public Student(String username, String password, String name, int NIC, String address, String gender, double balance) {
        super(username, password);
        this.name = name;
        this.NIC = NIC;
        this.address = address;
        this.gender = gender;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getNIC() {
        return NIC;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNIC(int NIC) {
        this.NIC = NIC;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
