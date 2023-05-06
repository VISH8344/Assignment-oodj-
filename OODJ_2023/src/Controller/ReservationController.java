package Controller;

import Model.Application;
import Model.Reservation;
import Util.FileName;
import Util.FileUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservationController implements Controller {

    ArrayList<Reservation> reservations;
    private static ReservationController reservationController;

    public static ReservationController ActivateReservationController() {
        if (ReservationController.reservationController == null) {
            ReservationController.reservationController = new ReservationController();
        }
        return ReservationController.reservationController;
    }

    ReservationController() {
        this.reservations = new ArrayList<>();
        ArrayList<String[]> textRecords = FileUtil.ReadFile(FileName.RESERVATION);
        textRecords.forEach(record -> {
            Reservation loadedObject = fromTextToObject(record);
            reservations.add(loadedObject);
        });
    }

    private Reservation fromTextToObject(String[] splittedLine) {
        int id = Integer.parseInt(splittedLine[0]);
        LocalDateTime checkIn = LocalDateTime.parse(splittedLine[1]);
        LocalDateTime checkOut = LocalDateTime.parse(splittedLine[2]);
        int contract = Integer.parseInt(splittedLine[3]);
        int applicationID = Integer.parseInt(splittedLine[4]);
        Application application = ApplicationController.ActivateApplicationController().getApplicationById(applicationID);
        return new Reservation(id, application, checkIn, checkOut, contract);
    }

    private ArrayList<String> fromObjectToText() {
        ArrayList<String> fileContents = new ArrayList<>();
        reservations.forEach(re -> {
            fileContents.add(
                    re.getReservationID() + ";"
                    + re.getCheckInDateTime() + ";"
                    + re.getCheckOutDateTime()
                    + ";" + re.getcontractPeriodWeeks()
                    + ";" + re.getApplication().getApplicationID());
        });
        return fileContents;
    }

    private int generateUniqueNumber(int num) {
        return num + 1;
    }

    private boolean checkIDIsExist(int id) {
        boolean isFound = false;
        for (Reservation reservation : reservations) {
            if (reservation.getReservationID() == id) {
                isFound = true;
            }
        }
        return isFound;
    }

    @Override
    public int getNewID() {
        int tempNewId = reservations.size() + 1;
        boolean isIDExist = checkIDIsExist(tempNewId);
        while (isIDExist) {
            tempNewId = generateUniqueNumber(tempNewId);
            if (!checkIDIsExist(tempNewId)) {
                break;
            }
        }
        return tempNewId;
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public Reservation getReservationById(int id) {
        Reservation response = null;
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationID() == id) {
                response = reservations.get(i);
                break;
            }
        }
        if (response == null) {
            System.out.println("Reservation with this id : " + id + " is not found");
        }
        return response;
    }

    public Reservation getReservationByStudentID(int studentID) {
        Reservation response = null;
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getApplication().getStudent().getStudentID() == studentID) {
                response = reservations.get(i);
                break;
            }
        }
        if (response == null) {
            System.out.println("Reservation with this studentID : " + studentID + " is not found");
        }
        return response;
    }

    public void add(Reservation Reservation) {
        this.reservations.add(Reservation);
        saveRecords();
    }

    public void updateReservation(Reservation reserve) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationID() == reserve.getReservationID()) {
                reservations.set(i, reserve);
                break;
            }
        }
        saveRecords();
    }

    @Override
    public void saveRecords() {
        System.out.println("reservations: " + reservations.toString());
        FileUtil.WriteToFile(FileName.RESERVATION, fromObjectToText());
    }

    // Testing
//    public static void main(String[] args) {
//        ReservationController sc = reservationController.ActivateReservationController();
//        sc.getReservations().forEach(Reservation -> {
//            System.out.println(Reservation.getCheckInDateTime());
//        });
//        
////        System.out.println(sc.getNewID());
//        System.out.println(sc.getReservationById(1));
//    }
}
