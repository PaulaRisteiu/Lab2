package ui;

import domain.Room;
import service.RoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Consola {
    private Scanner scanner = new Scanner(System.in);
    private RoomService roomService;
    public Consola(RoomService roomService) {
        this.roomService = roomService;
    }

    public void runConsole() {
        readRoom();
        displayRoom();
        updateBeds();
        deleteRoom();
        displayRoom();
        profitability();
        typeRoom();
    }
    public void readRoom() {
        System.out.println("Enter roomNumbers: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            Room room = new Room();
            System.out.println("Enter idRoom: ");
            room.setIdRoom(scanner.nextInt());
            System.out.println("Enter roomName: ");
            room.setRoomName(scanner.next());
            System.out.println("Enter pricePerNight: ");
            room.setPricePerNight(scanner.nextFloat());
            System.out.println("Enter beds number: ");
            room.setBeds(scanner.nextInt());
            System.out.println("Enter type: ");
            room.setType(scanner.next());
            try {
                roomService.addRoom(room);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void displayRoom() {
        if (roomService.getAllRooms().isEmpty()) {
            System.out.println("The list has no records");
        }
        for (Room room : roomService.getAllRooms()) {
            System.out.println("Id room: " + room.getIdRoom() + "| Room name: " + room.getRoomName() + "| Price: " + room.getPricePerNight() + "| Beds: " + room.getBeds() + "|Type: " + room.getType());
        }
    }

    public void updateBeds() {
        // Room room = new Room();
        System.out.println("Enter idRoom for update");
        int idUpdate = scanner.nextInt();
        System.out.println("Enter beds number for update: ");
        int bedsUpdate = scanner.nextInt();

        boolean flag = roomService.updateRoom(idUpdate, bedsUpdate);

        if (flag) {
            List<Room> allRooms = roomService.getAllRooms();
            System.out.println(roomService.getAllRooms());
        } else {
            System.out.println("No update");
        }
    }

    public void deleteRoom() {
        System.out.println("Enter id room for delete: ");
        int roomId = scanner.nextInt();
        roomService.delete(roomId);


//       List<Room> newList = roomService.delete(roomId);
//           System.out.println(newList);
    }

    public void profitability() {
        List<Room> filter = new ArrayList<>();
        roomService.yieldFilter(filter);
        System.out.println(filter);
    }

    public void typeRoom() {
        Map<String, Double> reportMap = roomService.typeReport();
        for (String type : reportMap.keySet()) {
            System.out.println(" Room Type = " + type + " average beds = " + reportMap.get(type));
        }
    }
}
