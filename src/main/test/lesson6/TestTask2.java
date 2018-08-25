import lesson6.Task1Task2;
import org.junit.Assert;
import org.junit.Test;

public class TestTask2 {

    int[] arr1 = {1,4,1,4,1,4,1,4,1,4};
    int[] arr2 = {1,4,1,4,1,4,1,4,1,2};
    int[] arr3 = {1,1,1,1};
    int[] arr4 = {4,4,4,4};

    @Test
    public void checkMassTest1(){
        Assert.assertTrue(Task1Task2.task2checkMass(arr1));
    }

    @Test
    public void checkMassTest2(){
        Assert.assertFalse(Task1Task2.task2checkMass(arr2));
    }

    @Test
    public void checkMassTest3(){
        Assert.assertFalse(Task1Task2.task2checkMass(arr3));
    }

    @Test
    public void checkMassTest4(){
        Assert.assertFalse(Task1Task2.task2checkMass(arr4));
    }
}
