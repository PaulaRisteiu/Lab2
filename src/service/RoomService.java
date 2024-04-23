package service;

import domain.Room;

import java.util.*;

public class RoomService {

    private Scanner scanner = new Scanner(System.in);
    private List<Room> roomList = new ArrayList<>();

    public RoomService() {
        this.roomList = new ArrayList<>();
    }

    public List<Room> getAllRooms() {
        return roomList;
    }

    public void addRoom(Room room) throws Exception {

        if (!room.getType().equals("Regular") && !room.getType().equals("Business") && !room.getType().equals("Executive") && !room.getType().equals("VIP")) {
            throw new Exception("Invalid type " + room.getType());
        }
        if (room.getBeds() < 1 || room.getBeds() > 5) {
            throw new Exception("Invalid number of beds " + room.getBeds());
        }
        roomList.add(room);
    }

    public boolean updateRoom(int idUpdate, int bedsUpdate) {
        boolean flag = false;
        for (Room room : roomList) {
            if (room.getIdRoom() == idUpdate) {
                room.setBeds(bedsUpdate);
                flag = true;
            }
        }
        return flag;
    }

    //    public List<Room> delete(int roomId) {
//
//        List<Room> newRoomList = new ArrayList<>();
//        boolean flag = false;
//        for (int i = 0; i < roomList.size(); i++) {
//            Room room = roomList.get(i);
//            if (roomId != room.getIdRoom()) {
//                newRoomList.add(room);
//            } else {
//                flag = true;
//            }
//        }
//        return newRoomList;
//    }
    public void delete(int roomId) {
        Room deleteRoom = null;
        for (Room room : roomList) {
            if (room.getIdRoom() == roomId) {
                deleteRoom = room;
            }
        }
        roomList.remove(deleteRoom);
    }

    public void yieldFilter(List<Room> filterList) {
        for (int i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            double yield = room.getPricePerNight() / room.getBeds();
            room.setYield(yield);
            filterList.add(room);
        }
        for (int i = 0; i < filterList.size(); i++) {
            for (int j = 0; j < filterList.size() - 1; j++) {
                if (filterList.get(i).getYield() > filterList.get(j).getYield()) {
                    Room filterRoom = filterList.get(j + 1);
                    filterList.set(j + 1, filterList.get(i));
                    filterList.set(i, filterRoom);
                }
            }
        }
    }

    public Room findById(int idFound) {
        for (Room room : roomList) {
            if (room.getIdRoom() == idFound) {
                return room;
            }
        }
        return null;
    }

    //pentru fiecare tip de cameră afișați media numărului de
    // paturi din camere de acel tip.

    public Map<String, Double> typeReport() {
        Map<String, Double> roomBedsMap = new HashMap<>();
        Map<String, Integer> numberOfRoomsMap = new HashMap<>();
        Map<String, Double> resultMap = new HashMap<>();

//        for (Room room : roomList) {
//            String type = room.getType();
//            double beds = room.getBeds();
//            roomBedsMap.put(type, beds);
//        }
        roomBedsMap.put("Regular", 0d);
        roomBedsMap.put("Business", 0d);
        roomBedsMap.put("Executive", 0d);
        roomBedsMap.put("VIP", 0d);

        numberOfRoomsMap.put("Regular", 0);
        numberOfRoomsMap.put("Business", 0);
        numberOfRoomsMap.put("Executive", 0);
        numberOfRoomsMap.put("VIP", 0);

        for (Room room : roomList) {
            String type = room.getType();
            if (roomBedsMap.containsKey(type)) {
                double currentNumberOfBeds = roomBedsMap.get(type);
                roomBedsMap.put(type, currentNumberOfBeds + room.getBeds());
            } else {
                roomBedsMap.put(type, (double) room.getBeds());
            }
            numberOfRoomsMap.put(type, numberOfRoomsMap.get(type) + 1);
        }
        for (String type : numberOfRoomsMap.keySet()) {
            double totalBeds = roomBedsMap.get(type);
            int totalRooms = numberOfRoomsMap.get(type);
            double averageBeds;
            if (totalRooms > 0) {
                averageBeds = totalRooms / totalBeds;
            } else {
                averageBeds = totalRooms;
            }
            resultMap.put(type, averageBeds);
        }

        return resultMap;
    }
//    public void type(List<Room> roomType) {
//
//        double nrRegularRooms=0;
//        double nrRegularBeds=0;
//        double nrBusinessRooms=0;
//        double nrBusinessBeds=0;
//        double nrExecutiveRooms=0;
//        double nrExecutiveBeds=0;
//        double nrVIPRooms=0;
//        double nrVIPBeds=0;

//        for (int i=0; i<roomList.size(); i++) {
//            Room room = roomList.get(i);
////            if (roomList.get(i).getType().equals("Regular")) {
////                nrRegularRooms++;
////                nrRegularBeds += room.getBeds();
////            }
//
//            if (room.getType().equals("Regular")) {
//                nrRegularRooms++;
//                nrRegularBeds+=room.getBeds();
//            }
//
//            if (roomList.get(i).getType().equals("Business")) {
//                nrBusinessRooms++;
//                nrBusinessBeds += room.getBeds();
//            }
//
//            if (roomList.get(i).getType().equals("Executive")) {
//                nrExecutiveRooms++;
//                nrExecutiveBeds += room.getBeds();
//            }
//
//            if (roomList.get(i).getType().equals("VIP")) {
//                nrVIPRooms++;
//                nrVIPBeds += room.getBeds();
//            }
//
//            double typeRegular = nrRegularBeds / nrRegularRooms;
//            double typeBusiness = nrBusinessBeds / nrBusinessRooms;
//            double typeExecutive = nrExecutiveBeds / nrExecutiveRooms;
//            double typeVIP = nrVIPBeds / nrVIPRooms;
//
//            room.setAverageType(typeRegular);
//            room.setAverageTypeBusiness(typeBusiness);
//            room.setAverageTypeExecutive(typeExecutive);
//            room.setAverageTypeVIP(typeVIP);
//
//            roomType.add(room);
//        }
//    }
}
