package com.hladchenko.chat.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try (Socket socket = new Socket("127.0.0.1", 8899)) {

            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);

            printWriter.print("It works!");
            printWriter.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
