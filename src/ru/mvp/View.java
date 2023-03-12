package ru.mvp;

import ru.Guest;

import java.io.IOException;
import java.util.List;

public interface View {

    void setRemoveGuest(Command command);

    void setGuestList(Command command);

    void setExit(Command command);

    void setWriteFile(Command command);

    void setReadFile(Command command);

    void setAddGuest(Command command);

    void update() throws ClassNotFoundException, IOException;

    Guest getGuestName();

    boolean getIsRoomAvailable();

    void showGuestList(List<Guest> guestList);
}
