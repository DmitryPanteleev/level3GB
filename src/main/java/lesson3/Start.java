package lesson3;


import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Start {

    public static void main(String[] args) throws Exception {
        writeByteMass("src/main/java/lesson3/file1.txt");
        writeManyMass("src/main/java/lesson3/file2.txt",
                "src/main/java/lesson3/file3.txt",
                "src/main/java/lesson3/file4.txt",
                "src/main/java/lesson3/file5.txt",
                "src/main/java/lesson3/file6.txt"
        );
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

    static void writeBigFile() {
        long start = System.currentTimeMillis();

        System.out.println();
        System.out.println(System.currentTimeMillis() - start + " миллесекунд выполнялось третье задание");
    }
}
