package Controller;

import Model.HostelRoom;
import Model.HostelSubClass.PremiumSingleRoom;
import Model.HostelSubClass.PremiumTwinRoom;
import Model.HostelSubClass.SingleRoom;
import Model.HostelSubClass.TwinRoom;
import Util.FileName;
import Util.SerializationUtil;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HostelRoomController implements Controller {

    ArrayList<HostelRoom> rooms;
    private static HostelRoomController roomController;

    public static HostelRoomController ActivateHostelRoomController() {
        if (HostelRoomController.roomController == null) {
            HostelRoomController.roomController = new HostelRoomController();
        }
        return HostelRoomController.roomController;
    }

    HostelRoomController() {
        this.rooms = new ArrayList<>();
        rooms = (ArrayList<HostelRoom>) SerializationUtil.readObjectFromFile(FileName.ROOM);
    }

    @Override
    public int getNewID() {
        return rooms.size() + 1;
    }

    public ArrayList<HostelRoom> getHostelRooms() {
        return this.rooms;
    }

    public HostelRoom getHostelRoomById(int id) {
        return rooms.stream()
                .filter(room -> room.getRoomID()== id)
                .findFirst()
                .orElse(null);
    }
    
    public ArrayList<SingleRoom> getSingleRooms(){
       return rooms.stream()
            .filter(room -> room instanceof SingleRoom)
            .map(room -> (SingleRoom) room)
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<TwinRoom> getTwinRooms(){
       return rooms.stream()
            .filter(room -> room instanceof TwinRoom)
            .map(room -> (TwinRoom) room)
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<PremiumSingleRoom> getPremiumSingleRooms(){
       return rooms.stream()
            .filter(room -> room instanceof PremiumSingleRoom)
            .map(room -> (PremiumSingleRoom) room)
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<PremiumTwinRoom> getPremiumTwinRooms(){
       return rooms.stream()
            .filter(room -> room instanceof PremiumTwinRoom)
            .map(room -> (PremiumTwinRoom) room)
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public void addHostelRoom(HostelRoom room) {
        this.rooms.add(room);
        saveRecords();
    }

    public void updateHostelRoom(HostelRoom room) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomID()== room.getRoomID()) {
                rooms.set(i, room);
                break;
            }
        }
        saveRecords();
    }
    
    public void deleteHostelRoom(HostelRoom room){
        try{
            if(rooms.remove(room)){
                saveRecords();
            }
            else{
                throw new Exception();
            }
        }catch (Exception ex){
            System.out.println("err occured when deleting hostel room. err: "+ ex.getMessage());
        }
    }

    @Override
    public void saveRecords() {
        SerializationUtil.writeObjectToFile(this.rooms, FileName.ROOM);
    }
    
// // Testing
//    public static void main(String[] args) {
//        HostelRoomController rc = roomController.ActivateHostelRoomController();
//        
////        rc.getHostelRooms().forEach(room -> {
////            System.out.println(room.getRoomID());
////        });
//        
//        rc.getSingleRooms().forEach(room -> {
//            System.out.println(room.getType());
//            System.out.println(room.toString());
//        });
//    }
}
