package ru.kvdl.Transmitter;

import java.io.IOException;
import java.net.Socket;

public class ConnectionUnit {
    public ConnectionUnit(Socket server, Socket client, byte[] usedBytes) throws IOException {
        // Отправка данных от клиента серверу
        server.getOutputStream().write(usedBytes);
        new Thread( new Streamer(client.getInputStream(), server.getOutputStream()) );
        new Thread( new Streamer(server.getInputStream(), client.getOutputStream()) );
    }

}
