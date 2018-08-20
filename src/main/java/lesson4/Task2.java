package lesson4;

import java.io.*;

public class Task2 {
    private static File file = new File("src/main/java/lesson4/file.txt");

    public static void main(String[] args) {
        writeString();
    }

    private static void writeString() {
        try {
            FileOutputStream out = new FileOutputStream("src/main/java/lesson4/file.txt");
            for (int i = 1; i <= 3; i++) {
                int y = i;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (file) {
                            for (int i = 0; i < 10; i++) {
                                String string = "String" + y + "\n";
                                try {
                                    out.write(string.getBytes());
                                    Thread.sleep(20);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }).start();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Значения записаны в файл, для просмотра открой созданный в lesson4 file.txt ");
    }
}