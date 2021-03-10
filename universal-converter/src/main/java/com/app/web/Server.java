package com.app.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class. The main duty to start new Speaker thread after new connection.
 *
 * @version 1.0.0 10 Mar 2021
 * @author Aleksey Lakhanskii
 *
 */
public class Server {

    public int port;

    public Server(int serverPort) {
        port = serverPort;
    }

    public void launch() {
        try (var server = new ServerSocket(this.port)) {
            while (true) {
                Socket socket = server.accept();
                Thread thread = new Speaker(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
