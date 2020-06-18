package lesson3;


import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class StartTask1Task2Task3 {

    public static void main(String[] args) throws Exception {
        writeByteMass("src/main/java/lesson3/file1.txt");

        writeManyMass("src/main/java/lesson3/file2.txt",
                "src/main/java/lesson3/file3.txt",
                "src/main/java/lesson3/file4.txt",
                "src/main/java/lesson3/file5.txt",
                "src/main/java/lesson3/file6.txt"
        );

        writeBigFile("src/main/java/lesson3/fileBig.txt");
    }

    static void writeByteMass(String path) {
        long start = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream(path)) {
            byte[] arr = new byte[60];
            int x;
            while ((x = in.read(arr)) != -1) {
                System.out.println(new String(arr, 0, x));
            }
            ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(System.currentTimeMillis() - start + " миллесекунд выполнялось первое задание");
    }

    static void writeManyMass(String... path) throws Exception {
        long start = System.currentTimeMillis();
        ArrayList<InputStream> arr = new ArrayList<>();
        for (int i = 0; i < path.length; i++) {
            arr.add(new FileInputStream(path[i]));
        }
        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(arr));
        int x;
        while ((x = in.read()) != -1) {
            System.out.print((char) x);
        }
        in.close();
        System.out.println();
        System.out.println(System.currentTimeMillis() - start + " миллесекунд выполнялось второе задание");
    }

    static void writeBigFile(String path) {
        long start = System.currentTimeMillis();

        try (InputStream in = new BufferedInputStream(new FileInputStream(path))) {
            byte[] arr = new byte[15000000];
            in.mark(10);
            int x;
            while ((x = in.read(arr)) != -1) ;

            System.out.println();
            System.out.println(System.currentTimeMillis() - start + " миллесекунд выполнялось чтение в третьем задании");
            System.out.println();

            long start2 = System.currentTimeMillis();
            for (int i = 0; i < 1800; i++) {
                System.out.print((char) arr[i]);
            }
            System.out.println();
            System.out.println(System.currentTimeMillis() - start2 + " миллесекунд выполнялся вывод в третьем задании");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
