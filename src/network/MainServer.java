package network;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {
    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8188);
            System.out.println("server running, wait connecting client");
            socket = server.accept();
            System.out.println("client connecting: " + socket.getLocalAddress() + " local port: " + socket.getLocalPort());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

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

            while (true){

                String str = in.readUTF();

                if (str.equals("/end")){
                    out.writeUTF(str);
                    System.out.printf("client disconnected");
                    break;
                }

                System.out.printf("client: " + str + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
