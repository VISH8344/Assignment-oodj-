package Model;

import Model.Enum.RoomType;

public abstract class Room {
    private int roomNumber;
    private int capacity;
    private double price;
    private boolean room_available;
    
    public Room(int roomNumber, int capacity, double price, boolean room_available) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.room_available = room_available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public boolean isRoom_available() {
        return room_available;
    }

    public void setRoom_available(boolean room_available) {
        this.room_available = room_available;
    }

    public void setRoom_available() {
        if (getCapacity() == 0) {
            setRoom_available(true);
        } else {
            setRoom_available(false);
        }
    }
    
    public abstract RoomType getRoomType();

}
