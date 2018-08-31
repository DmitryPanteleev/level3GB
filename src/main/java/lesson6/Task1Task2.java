package lesson6;

public class Task1Task2 {

    public static void printArray(int[] array) {
        for (int i :
                array) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static int[] task1NewMass(int[] inArr) throws RuntimeException {
        int count = 0;
        for (int i = inArr.length - 1; i >= 0; i--) {
            count++;
            if (inArr[i] == 4) {
                break;
            }
        }
        if (count == inArr.length) {
            throw new RuntimeException("not number 4");
        }
        int[] outArr = new int[count];
        for (int i = inArr.length - 1; i >= inArr.length - count; i--) {
            int y = i - (inArr.length - count);
            outArr[y] = inArr[i];
        }

        return outArr;
    }

    public static boolean task2checkMass(int[] inArr) {
        boolean flag1 = false;
        boolean flag2 = false;

        for (int i :
                inArr) {
            if (i != 1 && i != 4) {
                return false;
            } else if (i == 1) {
                flag1 = true;
            } else {
                flag2 = true;
            }
        }
        if (flag1 == true && flag2 == true) {
            return true;
        } else {
            return false;
        }
    }

}
