package Controller;

import Model.Enum.Facility;
import Model.Enum.RoomType;
import Model.HostelRoom;
import Model.HostelSubClass.PremiumSingleRoom;
import Model.HostelSubClass.PremiumTwinRoom;
import Model.HostelSubClass.SingleRoom;
import Model.HostelSubClass.TwinRoom;
import Util.FileName;
import Util.FileUtil;
import Util.SerializationUtil;
import java.util.ArrayList;

public class HostelRoomController implements Controller {

    private ArrayList<HostelRoom> rooms;
    private static HostelRoomController roomController;

    public static HostelRoomController ActivateHostelRoomController() {
        if (HostelRoomController.roomController == null) {
            HostelRoomController.roomController = new HostelRoomController();
        }
        return HostelRoomController.roomController;
    }

    HostelRoomController() {
        this.rooms = new ArrayList<>();
        ArrayList<String[]> textRecords = FileUtil.ReadFile(FileName.ROOM);
        textRecords.forEach(record -> {
            HostelRoom loadedObject = fromTextToObject(record);
            rooms.add(loadedObject);
        });
    }

    private HostelRoom fromTextToObject(String[] splittedLine) {
        HostelRoom response = null;
        int roomID = Integer.parseInt(splittedLine[0]);
        RoomType type = RoomType.valueOf(splittedLine[1]);
        boolean available = Boolean.parseBoolean(splittedLine[2]);
        int capacity = Integer.parseInt(splittedLine[3]);
        String formatFacilityText = splittedLine[4].substring(1, splittedLine[4].length() - 1);
        String[] eachFacilityText = formatFacilityText.split(",");
        ArrayList<Facility> facilities = new ArrayList<>();
        for (String s : eachFacilityText) {
            facilities.add(Facility.valueOf(s));
        }
        double price = Double.parseDouble(splittedLine[5]);
        switch (type) {
            case SINGLE:
                response = new SingleRoom(roomID, available, capacity, facilities);
            case TWIN:
                response = new TwinRoom(roomID, available, capacity, facilities);
            case PREMIUMSINGLE:
                response = new PremiumSingleRoom(roomID, available, capacity, facilities);
            case PREMIUMTWIN:
                response = new PremiumTwinRoom(roomID, available, capacity, facilities);
        }
        return response;
    }

    private ArrayList<String> fromObjectToText() {
        ArrayList<String> fileContents = new ArrayList<>();
        rooms.forEach(room -> {
            switch (room.getClass().getSimpleName()) {
                case "SingleRoom" -> {
                    SingleRoom r = (SingleRoom) room;
                    fileContents.add(r.getRoomID() + ";" + r.getType() + ";" + r.isAvailable() + ";" + r.getCapacity() + ";" + r.getFacilities() + ";" + r.getRoomPrice());
                }
                case "TwinRoom" -> {
                    TwinRoom r = (TwinRoom) room;
                    fileContents.add(r.getRoomID() + ";" + r.getType() + ";" + r.isAvailable() + ";" + r.getCapacity() + ";" + r.getFacilities() + ";" + r.getRoomPrice());
                }
                case "PremiumSingleRoom" -> {
                    PremiumSingleRoom r = (PremiumSingleRoom) room;
                    fileContents.add(r.getRoomID() + ";" + r.getType() + ";" + r.isAvailable() + ";" + r.getCapacity() + ";" + r.getFacilities() + ";" + r.getRoomPrice());
                }
                case "PremiumTwinRoom" -> {
                    PremiumTwinRoom r = (PremiumTwinRoom) room;
                    fileContents.add(r.getRoomID() + ";" + r.getType() + ";" + r.isAvailable() + ";" + r.getCapacity() + ";" + r.getFacilities() + ";" + r.getRoomPrice());
                }
            }
        });
        return fileContents;
    }

    private int generateUniqueNumber(int num) {
        return num + 1;
    }

    private boolean checkIDIsExist(int id) {
        boolean isFound = false;
        for (HostelRoom room : rooms) {
            if (room.getRoomID() == id) {
                isFound = true;
            }
        }
        return isFound;
    }

    @Override
    public int getNewID() {
        int tempNewId = rooms.size() + 1;
        boolean isIDExist = checkIDIsExist(tempNewId);
        while (isIDExist) {
            tempNewId = generateUniqueNumber(tempNewId);
            if (!checkIDIsExist(tempNewId)) {
                break;
            }
        }
        return tempNewId;
    }

    public ArrayList<HostelRoom> getHostelRooms() {
        return this.rooms;
    }

    public HostelRoom getHostelRoomById(int id) {
        HostelRoom response = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomID() == id) {
                response = rooms.get(i);
                break;
            }
        }
        if (response == null) {
            System.out.println("Room with this id : " + id + " is not found");
        }
        return response;
    }

    public ArrayList<SingleRoom> getSingleRooms() {
        ArrayList<SingleRoom> response = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) instanceof SingleRoom) {
                response.add((SingleRoom) rooms.get(i));
            }
        }
        if (response == null) {
            System.out.println("There is no single room in the record.");
        }
        return response;
    }

    public ArrayList<TwinRoom> getTwinRooms() {
        ArrayList<TwinRoom> response = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) instanceof TwinRoom) {
                response.add((TwinRoom) rooms.get(i));
            }
        }
        if (response == null) {
            System.out.println("There is no twin room in the record.");
        }
        return response;
    }

    public ArrayList<PremiumSingleRoom> getPremiumSingleRooms() {
        ArrayList<PremiumSingleRoom> response = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) instanceof PremiumSingleRoom) {
                response.add((PremiumSingleRoom) rooms.get(i));
            }
        }
        if (response == null) {
            System.out.println("There is no premium single room in the record.");
        }
        return response;
    }

    public ArrayList<PremiumTwinRoom> getPremiumTwinRooms() {
        ArrayList<PremiumTwinRoom> response = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i) instanceof PremiumTwinRoom) {
                response.add((PremiumTwinRoom) rooms.get(i));
            }
        }
        if (response == null) {
            System.out.println("There is no premium twin room in the record.");
        }
        return response;
    }

    public ArrayList<HostelRoom> getAvailableRooms() {
        ArrayList<HostelRoom> response = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isAvailable()) {
                response.add((PremiumTwinRoom) rooms.get(i));
            }
        }
        if (response == null) {
            System.out.println("There is no available room in the record.");
        }
        return response;
    }

    public ArrayList<?> getAvailableRoomsByClassType(Class<?> classType) {
        ArrayList<HostelRoom> availableRooms = getAvailableRooms();
        ArrayList<HostelRoom> responseRooms = new ArrayList<>();
        for (int i = 0; i < availableRooms.size(); i++) {
            if (availableRooms.get(i).getClass() == classType) {
                responseRooms.add(availableRooms.get(i));
            }
        }
        if (responseRooms == null) {
            System.out.println("There is no available " + classType + "room in the record.");
        }
        return responseRooms;
    }

    public void add(HostelRoom room) {
        this.rooms.add(room);
        saveRecords();
    }

    public void update(HostelRoom room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomID() == room.getRoomID()) {
                rooms.set(i, room);
                break;
            }
        }
        saveRecords();
    }

    public void deleteHostelRoom(HostelRoom room) {
        try {
            if (rooms.remove(room)) {
                saveRecords();
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("err occured when deleting hostel room.\nerr: " + ex.getMessage());
        }
    }

    @Override
    public void saveRecords() {
        FileUtil.WriteToFile(FileName.ROOM, fromObjectToText());
    }

    // Testing
//    public static void main(String[] args) {
//        HostelRoomController rc = roomController.ActivateHostelRoomController();
//        
////        rc.getHostelRooms().forEach(room -> {
////            System.out.println(room.getRoomID());
////        });
//        
////        rc.getSingleRooms().forEach(room -> {
////            System.out.println(room.getType());
////            System.out.println(room.toString());
////        });
//
////        rc.getAvailableRoomsByClassType(PremiumSingleRoom.class).forEach(room -> {
////            System.out.println(room.getClass());
////        });
//        
//    }
}
