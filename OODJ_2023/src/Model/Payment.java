/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author mingl
 */
public class Payment implements Serializable{
    private int paymentID;
    private Student student;
    private HostelRoom room;
    private double amount;
    private LocalDate dateTime;
    private boolean  isRefunded;

    public Payment(int paymentID, Student student, HostelRoom room, double amount, LocalDate dateTime, boolean isRefunded) {
        this.paymentID = paymentID;
        this.student = student;
        this.room = room;
        this.amount = amount;
        this.dateTime = dateTime;
        this.isRefunded = isRefunded;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HostelRoom getRoom() {
        return room;
    }

    public void setRoom(HostelRoom room) {
        this.room = room;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(boolean isRefunded) {
        this.isRefunded = isRefunded;
    }

    
}
