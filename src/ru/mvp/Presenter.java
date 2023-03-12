package ru.mvp;

import ru.FileManager;
import ru.Guest;
import ru.Hotel;

import java.io.IOException;
import java.util.List;

public class Presenter {
    private View view;
    private Hotel hotel = null;

    public Presenter(View view) {this.view = view;
    }

    public void update() throws IOException, ClassNotFoundException {
        FileManager save = new FileManager();
        view.setAddGuest(createAddGuest());
        view.setRemoveGuest(createRemoveGuest());
        view.setGuestList(createGuestList());
        view.setExit(createExit());
        view.setWriteFile(createWriteFile(save));
        view.setReadFile(createReadFile(save));
        while (true) {
            view.update();
        }
    }

    private Command createAddGuest() {
        return () -> {
            Guest guestName = view.getGuestName();
            if (hotel == null) {
                hotel = new Hotel();
            }
            hotel.addGuest(guestName);
            view.update();
        };
    }

    private Command createRemoveGuest() {
        return () -> {
            Guest guestName = view.getGuestName();
            if (hotel != null) {
                hotel.removeGuest(guestName);
            }
            view.update();
        };
    }

    private Command createGuestList() {
        return () -> {
            List<Guest> guestList = null;
            if (hotel != null) {
                guestList = hotel.getGuestList();
            }
            view.showGuestList(guestList);
        };
    }

    private Command createIsRoomAvailable() {
        return () -> {
            boolean isAvailable = view.getIsRoomAvailable();
            if (hotel != null) {
                hotel.setIsRoomAvailable(isAvailable);
            }
            view.update();
        };
    }

    private Command createExit() {
        return () -> {
            System.exit(0);
        };
    }

    private Command createWriteFile(FileManager save) {
        return () -> {
            if (hotel != null) {
                save.writeFile(hotel);
            }
        };
    }

    private Command createReadFile(FileManager save) {
        return () -> {
            hotel = save.readFile();
            view.update();
        };
    }
}