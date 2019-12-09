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
        final int PORT = 8188;

            try {

            socket = new Socket(IP_ADRESS, PORT);
            // получаем с потока
            in = new DataInputStream(socket.getInputStream());
            // отправляем в поток
            out = new DataOutputStream(socket.getOutputStream());

                //Поток отправки данных
            DataOutputStream finalOut = out;
            new Thread(() -> {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String inputPhrases;
                    inputPhrases = scanner.nextLine();

                    try {
                        finalOut.writeUTF(inputPhrases);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

             new Thread(() -> {

                try {
                    while (true){
                        String str = in.readUTF();

                        if (str.equals("/end")){
                            System.out.printf("server disconnected");
                            break;

                        }else {
                            System.out.printf("server: " + str + "\n");
                        }

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

            } catch (IOException ex) {
            ex.printStackTrace();
            System.out.printf("error");
        }

    }

}
