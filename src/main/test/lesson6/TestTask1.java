import lesson6.Task1Task2;
import org.junit.Assert;
import org.junit.Test;

public class TestTask1 {

    public static int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    public static int[] array2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    public static int[] array3 = {0, 1, 2, 3};
    int[] arr = {4, 5, 6, 7, 8};
    int[] arr2 = {4, 3, 2, 1, 0};


    @Test(expected = RuntimeException.class)
    public void task1Exception() {
        Task1Task2.task1NewMass(array3);
    }

    @Test
    public void task1OutArray1(){
        Assert.assertArrayEquals(arr,Task1Task2.task1NewMass(array1));
    }

    @Test
    public void task1OutArray2(){
        Assert.assertArrayEquals(arr2,Task1Task2.task1NewMass(array2));
    }
}
