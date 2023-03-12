package ru;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    

    private List<Guest> guests;

    public Hotel() {
        this.guests = new ArrayList<>();
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public void addGuest(Guest guest) {
        if (isRoomAvailable(guest.getRoomNumber())) {
            guests.add(guest);
            System.out.println("Гость " + guest.getFirstName() + " " + guest.getLastName() + " добавлен в отель");
        } else {
            System.out.println("Комната номер " + guest.getRoomNumber() + " уже занята");
        }
    }

    public void removeGuest(Guest guest) {
        if (guests.contains(guest)) {
            guests.remove(guest);
            System.out.println("Гость " + guest.getFirstName() + " " + guest.getLastName() + " удален из отеля");
        } else {
            System.out.println("Гость не найден в отеле");
        }
    }

    private boolean isRoomAvailable(int roomNumber) {
        for (Guest guest : guests) {
            if (guest.getRoomNumber() == roomNumber) {
                return false;
            }
        }
        return true;
    }

    public List<Guest> getGuestList() {
        return guests;
    }

    public void setIsRoomAvailable(boolean isAvailable) {
    }
}
