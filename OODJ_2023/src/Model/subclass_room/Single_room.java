
package Model.subclass_room;

import Model.Room;
import Model.RoomType;

public class Single_room extends Room {
    
    public Single_room(int roomNumber, int capacity, double price, boolean room_available) {
        super(roomNumber, capacity, price, room_available);
    }
    
    @Override
    public RoomType getRoomType(){
        return RoomType.SINGLE;
    }

    
}
