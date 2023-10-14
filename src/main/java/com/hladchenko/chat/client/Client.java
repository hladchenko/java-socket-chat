package com.hladchenko.chat.client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        while (!line.equals("q")) {
            try (Socket socket = new Socket("127.0.0.1", 8899)) {

                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                PrintWriter printWriter = new PrintWriter(outputStreamWriter);

                System.out.print("Enter your message: ");
                line = bufferedReader.readLine();
                printWriter.println(line);
                printWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
