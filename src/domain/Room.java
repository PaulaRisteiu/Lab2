package domain;

public class Room {
    private int idRoom;
    private String roomName;
    private float pricePerNight;
    private int beds;
    private String type;
    private double yield;

    public Room() {
    }

    public Room(int idRoom, String roomName, float pricePerNight, int beds, String type) {
        this.idRoom = idRoom;
        this.roomName = roomName;
        this.pricePerNight = pricePerNight;
        this.beds = beds;
        this.type = type;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
            this.beds = beds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
           this.type = type;
    }

    public double getYield() {
        return yield;
    }
    public void setYield(double yield) {
        this.yield = yield;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "idRoom=" + idRoom +
                ", roomName='" + roomName + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", beds=" + beds +
                ", type='" + type + '\'' +
                ", yield= " + yield +
                '}';
    }
}
