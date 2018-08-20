package lesson4;

import java.io.*;

public class Task4 {
    private static File file = new File("src/main/java/lesson4/file2.txt");
    private static Object object = new Object();
    private static volatile int counterThred = 0;

    public static void main(String[] args) {
        createFile();
        writeFile();
    }

    private static void createFile() {
        try {
            FileOutputStream out = new FileOutputStream("src/main/java/lesson4/file2.txt");
            for (int i = 0; i < 10000; i++) {
                String number = String.valueOf((int) (1 + Math.random() * 10));
                out.write(number.getBytes());
                String str = "\n";
                if (i % 100 == 0) {
                    out.write(str.getBytes());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeFile() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int y = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (file) {
                        counterThred++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        while (counterThred > 4) {
                            try {
                                System.out.println("wait");
                                file.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("Thread " + y);
                        try {
                            FileInputStream in = new FileInputStream("src/main/java/lesson4/file2.txt");
                            DataInputStream din = new DataInputStream(in);
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(din));
                            while (true) {
                                String str = bufferedReader.readLine();
                                if (str != null) {
//                                    System.out.println(str);
                                    System.out.println(counterThred);
                                } else break;
                            }

                            file.notifyAll();
                            counterThred--;
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}