import service.RoomService;
import ui.Consola;

public class Main {
    public static void main(String[] args) {

        RoomService roomService = new RoomService();
        Consola roomConsole = new Consola(roomService);

        roomConsole.runConsole();
    }
}