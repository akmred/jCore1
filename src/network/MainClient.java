package network;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) {
        Socket socket;
        DataInputStream in;
        DataOutputStream out = null;
        final String IP_ADRESS = "localhost";
        final int PORT = 8189;
        Scanner scanner = new Scanner(System.in);
        String inputPhrases;

            try {

            socket = new Socket(IP_ADRESS, PORT);
            // получаем с потока
            in = new DataInputStream(socket.getInputStream());
            // отправляем в поток
            out = new DataOutputStream(socket.getOutputStream());

             new Thread(() -> {

                try {
                    while (true){
                        String str = in.readUTF();
                        System.out.printf(str + "\n");

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
             }).start();

            System.out.printf("enter phrases: ");
             inputPhrases = scanner.nextLine();
             out.writeUTF(inputPhrases);

            } catch (IOException ex) {
            ex.printStackTrace();
            System.out.printf("error");
        }

    }

}
