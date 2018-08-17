package lesson3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADRESS = "localhost";
    private static final int SERVER_PORT = 8189;
    private static Socket socket;
    private static Scanner scanner;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;

    public static void main(String[] args) {

        startClient();

    }

    public static void startClient() {
        try {
            socket = new Socket(SERVER_ADRESS, SERVER_PORT);
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
//                            String str = inputStream.readUTF();
//                            System.out.println(str);
                            ObjectInputStream in = new ObjectInputStream(new FileInputStream("out.txt"));
                            Student s2 = (Student) in.readObject();
                            s2.info();
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
