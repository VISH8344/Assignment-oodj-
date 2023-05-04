/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Enum.Facility;
import java.util.ArrayList;

/**
 *
 */
public class HostelRoom {

    private int roomID;
//    private RoomType roomType; //subclass attribute
    private boolean isAvailable;
    private int capacity;    
    private ArrayList<Facility> facilities;
    
    public HostelRoom(int roomID, boolean isAvailable, int capacity, ArrayList<Facility> facilities) {
        this.roomID = roomID;
        this.isAvailable = isAvailable;
        this.capacity = capacity;
        this.facilities = facilities;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(ArrayList<Facility> facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "HostelRoom{" + "roomID=" + roomID + ", isAvailable=" + isAvailable + ", capacity=" + capacity + ", facilities=" + facilities + '}';
    }
    
    
}
