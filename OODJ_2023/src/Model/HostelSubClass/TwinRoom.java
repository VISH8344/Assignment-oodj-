/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.HostelSubClass;

import Model.Enum.Facility;
import Model.Enum.RoomType;
import Model.HostelRoom;
import java.util.ArrayList;

/**
 *
 */
public class TwinRoom extends HostelRoom {
       private RoomType type = RoomType.TWIN;
       private double roomPrice = 600.0;

    public TwinRoom(int roomID, boolean isAvailable, int capacity, ArrayList<Facility> facilities) {
        super(roomID, isAvailable, capacity, facilities);
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }
    
}
