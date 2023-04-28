/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Admin;
import Model.Application;
import Model.Enum.ApplicationStatus;
import Model.Enum.Facility;
import Model.HostelRoom;
import Model.HostelSubClass.PremiumSingleRoom;
import Model.HostelSubClass.SingleRoom;
import Model.HostelSubClass.TwinRoom;
import Model.Payment;
import Model.Reservation;
import Model.Student;
import Model.User;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 *
 */
public class Config_Setup_Data {

    private ArrayList<Facility> facilities = new ArrayList<>();
    private Admin admin;
    private Student student;
    private HostelRoom room;
    private HostelRoom room2;
    private HostelRoom room3;
    private HostelRoom room4;
    private Application application;
    private Application application2;
    private Reservation reservation;
    private Payment payment;
    private Payment payment2;
    private Payment payment3;
    
    private final ArrayList<User> admins = new ArrayList<>();
    private final ArrayList<User> students = new ArrayList<>();
    private final ArrayList<HostelRoom> rooms = new ArrayList<>();
    private final ArrayList<Application> applications = new ArrayList<>();
    private final ArrayList<Reservation> reservations = new ArrayList<>();
    private final ArrayList<Payment> payments = new ArrayList<>();

    public void TempUserData() {
        admin = new Admin("admin", "123");
        student = new Student(1, "Cindy", "0211221122", "3, Jalan Jagong, Taman Bunga", "FEMALE", 1000.0,"cindy223","123");
        admins.add(admin);
        students.add(student);
        SerializationUtil.writeObjectToFile(this.admins, FileName.ADMIN);
        SerializationUtil.writeObjectToFile(this.students, FileName.STUDENT);
    }

    public void TempHostelData() {
        facilities.add(Facility.KITCHEN);
        facilities.add(Facility.AIRCOND);
         room = new SingleRoom(1, true, 1, facilities);
         room2 = new SingleRoom(2, true, 1, facilities);
         room3 = new TwinRoom(3, true, 2, facilities);
         room4 = new PremiumSingleRoom(4, true, 1, facilities);
         rooms.add(room);
         rooms.add(room2);
         rooms.add(room3);
         rooms.add(room4);
        SerializationUtil.writeObjectToFile(rooms, FileName.ROOM);
    }

    public void TempApplicationData() {
        application = new Application(1, student, room, LocalDateTime.now(), payment, ApplicationStatus.PENDING,"");
        application2 = new Application(1, student, room, LocalDateTime.now(), payment, ApplicationStatus.REJECTED,"");
        applications.add(application);
        applications.add(application2);
        SerializationUtil.writeObjectToFile(applications, FileName.APPLICATION);
    }
    
    public void TempReservationData() {
        reservation = new Reservation(1,application,LocalDateTime.now(),LocalDateTime.of(2023, 8, 31, 0, 0), 12);
        reservations.add(reservation);
        SerializationUtil.writeObjectToFile(reservations, FileName.RESERVATION);
    }
    
    public void TempPaymentData(){
        payment = new Payment(1, student, room, 500.0,LocalDateTime.now(), false);
        payment2 = new Payment(2, student, room, 500.0,LocalDateTime.now(), true);
        payment3 = new Payment(3, student, room, 500.0,LocalDateTime.now(), false);
        payments.add(payment);
        payments.add(payment2);
        payments.add(payment3);
        SerializationUtil.writeObjectToFile(payments, FileName.PAYMENT);
    }
    
    public static void InitializeData(){
        // // add temp data
        File folder = new File("data");
        if(!folder.exists() && !folder.isDirectory()){
            folder.mkdirs();
            Config_Setup_Data config = new Config_Setup_Data();
            config.TempUserData();
            config.TempHostelData();
            config.TempApplicationData();
            config.TempReservationData();
            config.TempPaymentData();
        }
    }
    
    public static void main(String[] args) {
        InitializeData();
    }
    
}
