package ru.mvp;

import ru.Guest;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Console implements View {

    private Command addGuest;
    private Command removeGuest;
    private Command exit;
    private Command guestList;
    private Command readFile;
    private Command writeFile;


    @Override

    public void update() throws ClassNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nМеню:");
        System.out.println("1. Добавить гостя");
        System.out.println("2. Удалить гостя");
        System.out.println("3. Показать список гостей");
        System.out.println("4. Выйти из программы");
        System.out.println("5. Сохранить в файл");
        System.out.println("6. Загрузить из файла");
        int number = scan.nextInt();
        if (number == 1) {
            addGuest.execute();
        } else if (number == 2) {
            removeGuest.execute();
        } else if (number == 3) {
            guestList.execute();
        } else if (number == 4) {
            exit.execute();
        } else if (number == 5) {
            writeFile.execute();
        } else if (number == 6) {
            readFile.execute();
        } else {
            System.out.println("Что то пошло не так");
        }


    }

    @Override
    public Guest getGuestName() {
        return null;
    }

    @Override
    public boolean getIsRoomAvailable() {
        return false;
    }

    @Override
    public void showGuestList(List<Guest> guestList) {

        if (guestList == null || guestList.isEmpty()) {
            System.out.println("Список гостей пуст");
            return;
        }
        System.out.println("Список гостей:");
        for (Guest guest : guestList) {
            System.out.println(guest.getFirstName() + " " + guest.getLastName() + ", комната " + guest.getRoomNumber());
        }

    }

    @Override

    public void setRemoveGuest(Command removeGuest) {
        this.removeGuest = removeGuest;
    }

    public void setGuestList(Command guestList) {
        this.guestList = guestList;
    }

    public void setExit(Command exit) {
        this.exit = exit;
    }

    public void setReadFile(Command readFile) {
        this.readFile = readFile;
    }

    @Override
    public void setAddGuest(Command addGuest) {
        this.addGuest = addGuest;

    }

    public void setWriteFile(Command writeFile) {
        this.writeFile = writeFile;
    }

}