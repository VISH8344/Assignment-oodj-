
package Model.subclass_room_old;

import Model.Room;
import Model.Enum.RoomType;

public class Premium_single_room extends Room {

    public Premium_single_room(int roomNumber, int capacity, double price, boolean room_available) {
        super(roomNumber, capacity, price, room_available);
    }
    @Override
    public RoomType getRoomType() {
        return RoomType.PREMIUMSINGLE;
    }
}
