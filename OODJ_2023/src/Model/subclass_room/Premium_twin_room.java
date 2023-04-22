
package Model.subclass_room;

import Model.Room;
import Model.Enum.RoomType;

public class Premium_twin_room extends Room {

    public Premium_twin_room(int roomNumber, int capacity, double price, boolean room_available) {
        super(roomNumber, capacity, price, room_available);
    }
    @Override
    public RoomType getRoomType() {
        return RoomType.PREMIUMTWIN;
    }
    
    public void setRoom_available() {
        if (getCapacity() == 0 || getCapacity() == 1) {
            setRoom_available(true);
        } else {
            setRoom_available(false);
        }
    }
}
