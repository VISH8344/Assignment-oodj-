package Model;

import java.time.LocalDateTime;

class Topups{
    private LocalDateTime dateTime;
    private double topupAmount;
    private Student student;

    public Topup(LocalDateTime dateTime, double topupAmount, Student student) {
        this.dateTime = dateTime;
        this.topupAmount = topupAmount;
        this.student = student;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTopupAmount() {
        return topupAmount;
    }

    public void setTopupAmount(double topupAmount) {
        this.topupAmount = topupAmount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
