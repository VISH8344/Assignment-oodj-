/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Enum.ApplicationStatus;
import Model.Payment;
import Model.Student;
import java.io.*;
import java.time.LocalDateTime;

/**
 *
 */
public class Application implements Serializable {

    private int applicationID;
    private Student student;
    private HostelRoom room;
    private LocalDateTime dateTime;
    private Payment payment;
    private ApplicationStatus applicationStatus;
    private String rejectedReason;

    public Application(int applicationID, Student student, HostelRoom room, LocalDateTime dateTime, Payment payment, ApplicationStatus applicationStatus, String rejectedReason) {
        this.applicationID = applicationID;
        this.student = student;
        this.room = room;
        this.dateTime = dateTime;
        this.payment = payment;
        this.applicationStatus = applicationStatus;
        this.rejectedReason = rejectedReason;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getRejectedReason() {
        return rejectedReason;
    }

    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
    }

    @Override
    public String toString() {
        return "Application{" + "applicationID=" + applicationID + ", student=" + student + ", room=" + room + ", dateTime=" + dateTime + ", payment=" + payment + ", applicationStatus=" + applicationStatus + ", rejectedReason=" + rejectedReason + '}';
    }
    
}
