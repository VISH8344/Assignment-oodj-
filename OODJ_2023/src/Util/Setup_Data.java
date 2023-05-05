/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Controller.ApplicationController;
import Controller.HostelRoomController;
import Controller.PaymentController;
import Controller.ReservationController;
import Controller.StudentController;
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
 * @author mingl
 */
public class Setup_Data {
    private ArrayList<Facility> facilities = new ArrayList<>();
    private ArrayList<Facility> facilities2 = new ArrayList<>();
    private ArrayList<Facility> facilities3 = new ArrayList<>();
    private ArrayList<Facility> facilities4 = new ArrayList<>();
    private ArrayList<Facility> facilities5 = new ArrayList<>();
    private ArrayList<Facility> facilities6 = new ArrayList<>();
    private ArrayList<Facility> facilities7 = new ArrayList<>();
    private ArrayList<Facility> facilities8 = new ArrayList<>();
    private ArrayList<Facility> facilities9 = new ArrayList<>();
    private Admin admin;
    private Student student;
    private HostelRoom room;
    private HostelRoom room2;
    private HostelRoom room3;
    private HostelRoom room4;
    private HostelRoom room11;
    private HostelRoom room12;
    private HostelRoom room13;
    private HostelRoom room14;
    private HostelRoom room15;
    private Application application;
    private Application application2;
    private Reservation reservation;
    private Payment payment;
    private Payment payment2;
    private Payment payment3;
    
    private final ArrayList<User> students = new ArrayList<>();
    private final ArrayList<HostelRoom> rooms = new ArrayList<>();
    private final ArrayList<Application> applications = new ArrayList<>();
    private final ArrayList<Reservation> reservations = new ArrayList<>();
    private final ArrayList<Payment> payments = new ArrayList<>();
    
    
    public void TempUserData(){
        admin = new Admin("admin", "123");
        student = new Student(1, "Cindy", "0211221122", "3, Jalan Jagong, Taman Bunga", "FEMALE", 1000.0,"cindy223","123");
        ArrayList<String> adminFileContent = new ArrayList<>();
        adminFileContent.add(admin.getUsername() + ";" + admin.getPassword());
        FileUtil.WriteToFile(FileName.ADMIN, adminFileContent);
        StudentController.ActivateStudentController().add(student);
    }
    
    public void TempHostelData() {
        facilities.add(Facility.KITCHEN);
        facilities.add(Facility.AIRCOND);
        facilities2.add(Facility.AIRCOND);
        facilities2.add(Facility.AIRCOND);
        facilities2.add(Facility.TELEVISION);
        facilities3.add(Facility.AIRCOND);
        facilities4.add(Facility.AIRCOND);
        facilities5.add(Facility.AIRCOND);
        facilities5.add(Facility.ATTACHED_BATHROOM);
        facilities6.add(Facility.KITCHEN);
        facilities7.add(Facility.AIRCOND);
        facilities8.add(Facility.WASHING_MACHINE);
        facilities9.add(Facility.WASHING_MACHINE);
        
         room = new SingleRoom(1, true, 1, facilities);
         room2 = new SingleRoom(2, true, 1, facilities2);
         room11 = new SingleRoom(5, true, 1, facilities3);
         room12 = new SingleRoom(6, true, 1, facilities4);
         room3 = new TwinRoom(3, true, 2, facilities5);
         room13 = new TwinRoom(7, true, 2, facilities6);
         room4 = new PremiumSingleRoom(4, true, 1, facilities7);
         room14 = new PremiumSingleRoom(8, true, 1, facilities8);
         room15 = new PremiumSingleRoom(9, false, 0, facilities9);
         rooms.add(room);
         rooms.add(room2);
         rooms.add(room3);
         rooms.add(room4);
         rooms.add(room11);
         rooms.add(room12);
         rooms.add(room13);
         rooms.add(room14);
         rooms.add(room15);
         rooms.forEach(room -> {
             System.out.println("room: " + room.toString());
         });
         rooms.forEach(r -> HostelRoomController.ActivateHostelRoomController().add(r));
    }
    
     public void TempApplicationData() {
        application = new Application(1, student, room, LocalDateTime.now(), payment, ApplicationStatus.PENDING,"");
        application2 = new Application(2, student, room, LocalDateTime.now(), payment, ApplicationStatus.REJECTED,"");
        applications.add(application);
        applications.add(application2);
        applications.forEach(a -> ApplicationController.ActivateApplicationController().add(a));
    }
     
      public void TempReservationData() {
        reservation = new Reservation(1,application,LocalDateTime.now(),LocalDateTime.of(2023, 8, 31, 0, 0), 12);
        reservations.add(reservation);
        reservations.forEach(r -> ReservationController.ActivateReservationController().add(r));
    }
      
      public void TempPaymentData(){
        payment = new Payment(1, student, room, 500.0,LocalDateTime.now(), false);
        payment2 = new Payment(2, student, room, 500.0,LocalDateTime.now(), true);
        payment3 = new Payment(3, student, room, 500.0,LocalDateTime.now(), false);
        payments.add(payment);
        payments.add(payment2);
        payments.add(payment3);
        payments.forEach(p -> PaymentController.ActivatePaymentController().add(p));
    }
    
    public static void InitializeData(){
        // // add temp data
        File folder = new File("data");
        if(!folder.exists() && !folder.isDirectory()){
            folder.mkdirs();
            Setup_Data setup = new Setup_Data();
            setup.TempUserData();
            setup.TempHostelData();
            setup.TempPaymentData();
            setup.TempApplicationData();
            setup.TempReservationData();
        }
    }
    
    public static void main(String[] args) {
        InitializeData();
    }
}
