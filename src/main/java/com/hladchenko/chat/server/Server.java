package com.hladchenko.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8899)) {


            while (true) {
                Socket socket = accept(serverSocket);
                BufferedReader bufferedReader = getBufferedReader(socket);

                String line = bufferedReader.readLine();
                if (line != null) {
                    System.out.println(line);
                }
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static BufferedReader getBufferedReader(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private static Socket accept(ServerSocket serverSocket) throws IOException {
        return serverSocket.accept();
    }

}
