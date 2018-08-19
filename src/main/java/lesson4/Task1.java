package lesson4;

public class Task1 {

    static volatile char correntL = 'A';


    public static void main(String[] args) {
        Object object = new Object();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (object) {
                        try {
                            while (correntL != 'A') {
                                object.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("A");
                        object.notifyAll();
                        correntL = 'B';
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (object) {
                        try {
                            while (correntL != 'B') {
                                object.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("B");
                        object.notifyAll();
                        correntL = 'C';

                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    synchronized (object) {
                        try {
                            while (correntL != 'C') {
                                object.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.print("C");
                        object.notifyAll();
                        correntL = 'A';

                    }
                }
            }
        }).start();

    }
}
