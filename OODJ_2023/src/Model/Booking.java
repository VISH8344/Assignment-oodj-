
package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking implements Serializable{
    
    private int bookingID;
    private double totalPrice;
    private String bookingDate;
    private String student_username;
    private int roomNumber;
    private int contractPeriod;
    
    public Booking(int bookingID, double totalPrice, String bookingDate, String student_username, int roomNumber, int contractPeriod) {
        this.bookingID = bookingID;
        this.totalPrice = totalPrice;
        this.bookingDate = bookingDate;
        this.student_username = student_username;
        this.roomNumber = roomNumber;
        this.contractPeriod = contractPeriod;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(int contractPeriod) {
        this.contractPeriod = contractPeriod;
    }
    
    public LocalDate get_contract_end_date() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate startDate = LocalDate.parse(bookingDate, formatter);
        LocalDate endDate = startDate.plusMonths(contractPeriod);
        return endDate;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", totalPrice=" + totalPrice + ", bookingDate=" + bookingDate + ", student_username=" + student_username + ", roomNumber=" + roomNumber + ", contractPeriod=" + contractPeriod + '}';
    }
    
}
