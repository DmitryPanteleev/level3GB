package lesson7;

public class TestClass3 {


    @Test
    public static int method1(){
        System.out.println("method1 default value = 5");
        return 5;
    }

    @Test(value = 1)
    public static int method2(){
        System.out.println("method2 value = 1");
        return 1;
    }
    @Test(value = 10)
    public static int method3(){
        System.out.println("method3 value = 10");
        return 10;
    }

}
