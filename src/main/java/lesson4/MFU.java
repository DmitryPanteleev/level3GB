package lesson4;

public class MFU {

    private static String printed;
    private static String scan;
    //    private static boolean freePrinter = true;
//    private static boolean freeScaner = true;
    private static volatile Object object = new Object();
    private static volatile Object object2 = new Object();


    public static void setScan(String scan) {
        synchronized (object2) {
            MFU.scan = scan;
            scanner();
        }
    }

    public static void setPrinted(String printed) {
        synchronized (MFU.object) {
            MFU.printed = printed;
            printer();
        }


    }

    private static void printer() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("Начало печати");
                    System.out.println("Печатаю: " + printed);
                    System.out.println("Конец печати");
//                    try {
//                        MFU.object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }).start();


    }

    private static void scanner() {
        synchronized (object2) {
            System.out.println("Начало сканирования");
            System.out.println("Сканирую: " + scan);
            System.out.println("Конец сканирования");
        }

    }

}
