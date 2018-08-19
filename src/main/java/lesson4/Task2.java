package lesson4;

import java.io.*;

public class Task2 {
    private static File file = new File("src/main/java/lesson4/file.txt");

    public static void main(String[] args) {
        writeString();
    }

    private static void writeString() {
        for (int i = 1; i <= 3; i++) {
            int y = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (file) {
                        for (int i = 0; i < 10; i++) {
                            String string = "String" + y + "\n";
                            try {
                                FileOutputStream out = new FileOutputStream("src/main/java/lesson4/file.txt", true);
                                out.write(string.getBytes());
                                out.close();
                                Thread.sleep(20);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
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
    }
}
