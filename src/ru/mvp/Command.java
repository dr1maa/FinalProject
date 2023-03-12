package ru.mvp;

import java.io.IOException;

public interface Command {
    void execute() throws IOException, ClassNotFoundException;
}