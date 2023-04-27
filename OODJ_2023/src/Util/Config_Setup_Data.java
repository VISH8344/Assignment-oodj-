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
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 *
 */
public class Config_Setup_Data {

    private Admin admin;
    private Student student;
    private ArrayList<Facility> facilities = new ArrayList<>();
    private HostelRoom room;
    private HostelRoom room2;
    private HostelRoom room3;
    private HostelRoom room4;
    private Application application;
    private Application application2;
    private Reservation reservation;
    private Payment payment;
    private Payment payment2;

    public void TempUserData() {
        admin = new Admin("admin", "123");
        student = new Student("student", "123", "Cindy", 1, "jalan 2, taman halo", "female", 100.0);
        SerializationUtil.writeObjectToFile(admin, FileName.ADMIN);
        SerializationUtil.writeObjectToFile(student, FileName.STUDENT);
    }

    public void TempHostelData() {
        facilities.add(Facility.KITCHEN);
        facilities.add(Facility.AIRCOND);
         room = new SingleRoom(1, true, 1, facilities);
         room2 = new SingleRoom(2, true, 1, facilities);
         room3 = new TwinRoom(3, true, 2, facilities);
         room4 = new PremiumSingleRoom(4, true, 1, facilities);
         
        SerializationUtil.writeObjectToFile(room, FileName.ROOM);
        SerializationUtil.writeObjectToFile(room2, FileName.ROOM);
        SerializationUtil.writeObjectToFile(room3, FileName.ROOM);
        SerializationUtil.writeObjectToFile(room4, FileName.ROOM);
    }

    public void TempApplicationData() {
         application = new Application(1, student, room, LocalDateTime.now(), payment, ApplicationStatus.PENDING,"");
        application2 = new Application(1, student, room, LocalDateTime.now(), payment, ApplicationStatus.REJECTED,"");
        SerializationUtil.writeObjectToFile(application, FileName.APPLICATION);
        SerializationUtil.writeObjectToFile(application2, FileName.APPLICATION);
        SerializationUtil.writeObjectToFile(reservation, FileName.RESERVATION);
    }
    
    public void TempReservationData() {
        reservation = new Reservation(1,application,LocalDateTime.now(),LocalDateTime.of(2023, 8, 31, 0, 0), 12);
        SerializationUtil.writeObjectToFile(reservation, FileName.RESERVATION);
    }
    
    public void TempPaymentData(){
        payment = new Payment(1, student, room, 500.0,LocalDateTime.now(), false);
        payment2 = new Payment(1, student, room, 500.0,LocalDateTime.now(), true);
        SerializationUtil.writeObjectToFile(payment, FileName.PAYMENT);
        SerializationUtil.writeObjectToFile(payment2, FileName.PAYMENT);
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
