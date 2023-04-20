package Model.subclass_room;

import Model.Room;
import Model.RoomType;

public class Twin_room extends Room {

    public Twin_room(int roomNumber, int capacity, double price, boolean room_available) {
        super(roomNumber, capacity, price, room_available);
    }

    @Override
    public RoomType getRoomType() {
        return RoomType.TWIN;
    }

    public void setRoom_available() {
        if (getCapacity() == 0 || getCapacity() == 1) {
            setRoom_available(true);
        } else {
            setRoom_available(false);
        }
    }
}
