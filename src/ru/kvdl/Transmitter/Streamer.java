package ru.kvdl.Transmitter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Streamer implements Runnable {
    private final InputStream input;
    private final OutputStream output;

    public Streamer(InputStream in, OutputStream out) {
        this.input = in;
        this.output = out;
    }

    public void run() {
        try {
            System.out.printf("Successfully transferred %d bytes\n", input.transferTo(output));
        } catch (IOException e) {e.printStackTrace();}
    }

}
