package lesson3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        startServer();

    }

    public static void startServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Server start, waiting connection...");
            socket = serverSocket.accept();
            System.out.println("Connection");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = inputStream.readUTF();
                            System.out.println(str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            while (true) {

                Student student = new Student("Name1","1","MVD");
//            ByteArrayOutputStream bs = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("out.txt"));
                oos.writeObject(student);
//                oos.close();
                student.info();
            }
//                outputStream.writeUTF("Server");
//                outputStream.flush();
//            }

        } catch (IOException e) {
            System.out.println("Exception Server initializer");
        } finally {
            try {

                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

