package lesson4;

import java.io.*;


public class DopDZ {
    private static File file = new File("src/main/java/lesson4/file2.txt");
    private static volatile Object object = new Object();
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

    /**
     * Этот метод создаёт десять потоков читающих из файла данные
     * есть несколько выводов в консоль для контроля выполнения условий задачи
     * раскоменчивая и закоменчивая их можно например увидеть сколько потоков сейчас имеют доступ к файлу
     * убрать вывод строк из файла, посмотреть какой поток запущен а какой ожидает своего часа
     *
     * По умолчанию запущен саут требуемый по заданию
     */
    private static void writeFile() {
        for (int i = 0; i < 10; i++) {
//
            int y = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (counterThred > 3) {
                        synchronized (file) {
                            try {
//                              Этот саут показывает ожидающий поток
//                                System.out.println("wait " + y);
                                file.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    counterThred++;
//                  этот саут указывает на запущенный поток
//                    System.out.println("Запущен Thread " + y);
                    try {
                        FileInputStream in = new FileInputStream("src/main/java/lesson4/file2.txt");
                        DataInputStream din = new DataInputStream(in);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(din));
                        while (true) {
                            String str = bufferedReader.readLine();
                            if (str != null) {
//                                этот самый бесполезный саут выводит в консоль кучу мусора (рандомных чисел из файла)
                                System.out.println(str);
//                                Этот саут выводит количество потоков одновременно подключённое к нашему файлу
//                                System.out.println("Количество потоков считывающих файл" + counterThred);
                            } else break;
                        }
                        synchronized (file) {
                            file.notifyAll();
                        }
                        counterThred--;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
//                }
            }).start();
        }
    }
}