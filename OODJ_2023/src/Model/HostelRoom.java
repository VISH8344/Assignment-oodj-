/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Enum.RoomType;

/**
 *
 * @author mingl
 */
public class HostelRoom {

    private int roomID;
    private RoomType roomType;
    private double roomPrice;
    private boolean isAvailable;

    public HostelRoom(int roomID, RoomType roomType, double roomPrice, boolean isAvailable) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isAvailable = isAvailable;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    
}
