package Student;

import Model.Reservation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Booking_DataIO {

    public static ArrayList<Reservation> booked_array = new ArrayList<Reservation>();

    public static void read() {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("booked_room.txt"));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String bookingId = data[0];
                int bookingID = Integer.parseInt(bookingId);
                String totalprice = data[1];
                double totalPrice = Double.parseDouble(totalprice);
                String bookingDate = data[2];
                String student_uname = data[3];
                int room_no = Integer.parseInt(data[4]);
                int contractPeriod = Integer.parseInt(data[5]);

                booked_array.add(new Reservation(bookingID, totalPrice, bookingDate, student_uname, room_no, contractPeriod));
            }
        } catch (Exception e) {
            System.out.println("read error in booking");
            e.printStackTrace();
        }
    }

    public static void write() {
        try {
            BufferedWriter bw = new BufferedWriter(new PrintWriter("booked_room.txt"));
            for (int i = 0; i < booked_array.size(); i++) {
                Reservation book_r = booked_array.get(i);
                bw.write(book_r.getBookingID() + ";"
                        + book_r.getTotalPrice() + ";"
                        + book_r.getBookingDate() + ";"
                        + book_r.getStudent_username() + ";"
                        + book_r.getRoomNumber() + ";"
                        + book_r.getContractPeriod());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error in write ...");
        }
    }
    



    public static Reservation checkStudentBooking(String student_username) {
        Reservation found = null;
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < booked_array.size(); i++) {
            Reservation s = booked_array.get(i);
            LocalDate contractEndDate = s.get_contract_end_date();
            if (student_username.equals(s.getStudent_username())) {
                if (currentDate.isBefore(contractEndDate)) {
                    found = s;
                    break;
                }
            }
        }
        return found;
    }

    public static ArrayList<Reservation> checkStudentBookings(String student_username) {
        ArrayList<Reservation> student_book_his = new ArrayList<Reservation>();
        for (int i = 0; i < booked_array.size(); i++) {
            Reservation br = booked_array.get(i);
            if (student_username.equals(br.getStudent_username())) {
                student_book_his.add(br);
            }
        }
        return student_book_his;
    }

    public static int get_last_bookingID() {
        int bookingID = 0;
        for (int i = 0; i < booked_array.size(); i++) {
            Reservation br = booked_array.get(i);
            bookingID = br.getBookingID();
        }
        return bookingID;
    }
}
