package Controller;

import Model.Reservation;
import Util.FileName;
import Util.SerializationUtil;
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
        reservations = (ArrayList<Reservation>) SerializationUtil.readObjectFromFile(FileName.RESERVATION);
    }

    @Override
    public int getNewID() {
        return reservations.size() + 1;
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public Reservation getReservationById(int id) {
        return reservations.stream()
                .filter(Reservation -> Reservation.getReservationID() == id)
                .findFirst()
                .orElse(null);
    }

    public Reservation getReservationByStudentID(int studentID) {
        return reservations.stream()
                .filter(reservation -> (reservation.getApplication().getStudent().getStudentID() == studentID))
                .findFirst()
                .orElse(null);
    }

    public void addReservation(Reservation Reservation) {
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
        SerializationUtil.writeObjectToFile(this.reservations, FileName.RESERVATION);
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
