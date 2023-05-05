/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 */
public class Reservation{

    private int reservationID;
    private Application application; // for student and room information
    private LocalDateTime checkInDateTime;
    private LocalDateTime checkOutDateTime;
    private int contractPeriodWeeks; //how many weeks

    public Reservation(int reservationID, Application application, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime, int contractPeriod) {
        this.reservationID = reservationID;
        this.application = application;
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
        this.contractPeriodWeeks = contractPeriodWeeks;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public LocalDateTime getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(LocalDateTime checkInDateTime) {
        this.checkInDateTime = checkInDateTime;
    }

    public LocalDateTime getCheckOutDateTime() {
        return checkOutDateTime;
    }

    public void setCheckOutDateTime(LocalDateTime checkOutDateTime) {
        this.checkOutDateTime = checkOutDateTime;
    }

    public int getcontractPeriodWeeks() {
        return contractPeriodWeeks;
    }

    public void setcontractPeriodWeeks(int contractPeriodWeeks) {
        this.contractPeriodWeeks = contractPeriodWeeks;
    }
}
