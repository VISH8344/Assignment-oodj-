package Student;

import Model.old.Room;
import Model.Enum.RoomType;
import Model.subclass_room_old.Premium_single_room;
import Model.subclass_room_old.Premium_twin_room;
import Model.subclass_room_old.Single_room;
import Model.subclass_room_old.Twin_room;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Room_DataIO {

    public static ArrayList<Room> array_room = new ArrayList<Room>();
    
    public static void read(){
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("room.txt"));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                int roomNumber = Integer.parseInt(data[0]);
                int roomCapacity = Integer.parseInt(data[1]);
                double roomPrice = Double.parseDouble(data[2]);
                boolean room_available = Boolean.parseBoolean(data[3]);

                RoomType roomType = RoomType.valueOf(data[4]);
                Room room = null;
                switch (roomType) {
                    case SINGLE -> room = new Single_room(roomNumber, roomCapacity, roomPrice, room_available);
                    case TWIN -> room = new Twin_room(roomNumber, roomCapacity, roomPrice, room_available);
                    case PREMIUMSINGLE -> room = new Premium_single_room(roomNumber, roomCapacity, roomPrice, room_available);
                    case PREMIUMTWIN -> room = new Premium_twin_room(roomNumber, roomCapacity, roomPrice, room_available);
                }

                if (room != null) {
                    array_room.add(room);
                }
            }
        } catch (Exception e) {
            System.out.println("error read in room dataIO");
            e.printStackTrace();
        }
    }
    public static void write() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("room.txt"));
            for (int i = 0; i < array_room.size(); i++) {
                Room room = array_room.get(i);
                writer.write(room.getRoomNumber() + ";"
                        + room.getCapacity() + ";"
                        + room.getPrice() + ";"
                        + room.isRoom_available() + ";"
                        + room.getRoomType());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error in write ...");
        }
    }

    public static Room checkAvailableRoomType(RoomType roomtype) {
        for (Room room : array_room) {
            if (room.getRoomType() == roomtype && room.isRoom_available()) {
                return room;
            }
        }
        return null;
    }
    
    
    public static Room checkRoom(int roomNumber) {
        Room found = null;
        for (int i = 0; i < array_room.size(); i++) {
            Room s = array_room.get(i);
            if (roomNumber == s.getRoomNumber()) {
                found = s;
                break;
            }
        }
        return found;
    }

}
