package ru.kvdl.Transmitter.thcontrol;

import ru.kvdl.Transmitter.ConnectionUnit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProcessingThread implements Runnable {
    private final Socket request;

    public ProcessingThread(Socket request) {
        this.request = request;
    }

    public void run() {
        while (true) {
            try {
                InputStream input = request.getInputStream();
                OutputStream output = request.getOutputStream();

                // Read first seven bytes to check header existence
                byte[] sign = input.readNBytes(7);
                String header = new String(sign);

                if (header.equals("-PIPE-\n")) {
                    MainStream.FROM_CLIENT = request;
                }
                else {
                    while (MainStream.FROM_CLIENT==null);
                    new ConnectionUnit( MainStream.FROM_CLIENT, request, sign);
                    MainStream.FROM_CLIENT = null;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
