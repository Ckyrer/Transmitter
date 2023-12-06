package ru.kvdl.Transmitter.thcontrol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainStream {
    public static Socket FROM_CLIENT;

    public static void start(int myPort) throws IOException {
        try (
            ServerSocket server = new ServerSocket(myPort);
        ) {
            new Thread( new ProcessingThread(server.accept()) ).start();
        }
    }
}
