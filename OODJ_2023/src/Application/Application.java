/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import Model.Payment;
import Model.Room;
import Model.Student;
import java.time.LocalDate;

/**
 *
 * @author mingl
 */
public class Application {
    private Student student;
    private Room room;
    private LocalDate dateTime;
    private Payment payment;
    private String rejectedReason;
    
    Application(
            Student student,
            Room room,
            LocalDate dateTime,
            Payment payment,
            String rejectedReason)
    {
        this.student = student;
        this.room = room;
        this.dateTime = dateTime;
        this.payment = payment;
        this.rejectedReason = rejectedReason;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
    }
}
