package ru;

import java.io.IOException;

public interface Save {
    void writeFile(Hotel hotel) throws IOException;

    Hotel readFile() throws IOException, ClassNotFoundException;
}

