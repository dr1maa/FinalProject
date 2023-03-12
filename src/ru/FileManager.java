package ru;

import java.io.*;

public class FileManager implements Save {
    public void writeFile(Hotel hotel) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(hotel);
        objectOutputStream.close();
    }

    public Hotel readFile() throws IOException, ClassNotFoundException {
        ObjectInput objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Hotel object1 = (Hotel) objectInputStream.readObject();
        objectInputStream.close();
        return object1;
    }

}

