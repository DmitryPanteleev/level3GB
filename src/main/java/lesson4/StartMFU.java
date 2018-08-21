package lesson4;

public class StartMFU {
    public static void main(String[] args) throws InterruptedException {

//        MFU.setPrinted("1");
//        MFU.setScan("2");
        for (int i = 0; i < 10; i++) {
            MFU.setPrinted(String.valueOf(i));
            MFU.setPrinted(String.valueOf(i));
            MFU.setPrinted(String.valueOf(i));
            MFU.setScan(String.valueOf(i));
            MFU.setScan(String.valueOf(i));
            MFU.setScan(String.valueOf(i));
        }
    }
}
