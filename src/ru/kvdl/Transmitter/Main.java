package ru.kvdl.Transmitter;

import ru.kvdl.Transmitter.thcontrol.MainStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            MainStream.start(1879);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}