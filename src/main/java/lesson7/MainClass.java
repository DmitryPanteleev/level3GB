package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        Class cl1 = TestClass1.class;
        Class cl2 = TestClass2.class;
        Class cl3 = TestClass3.class;
        start(cl1);
        System.out.println();
        start(cl3);
        System.out.println();
        Thread.sleep(500);
        start(cl2);
    }

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        Class cl = c.getClass();
        Method[] methods = c.getMethods();
        int afterClass = 0;
        int beforeClass = 0;

        for (Method m :
                methods) {
            if (m.getDeclaredAnnotation(BeforeSuite.class) != null) {
                beforeClass++;
            }
            if (m.getDeclaredAnnotation(AfterSuite.class) != null) {
                afterClass++;
            }
        }
        if ((afterClass | beforeClass) > 1) {
            throw new RuntimeException("((after | befor) class > 1)");
        }

        for (Method m :
                methods) {
            if (m.getDeclaredAnnotation(BeforeSuite.class) != null) {
                m.invoke(c, null);
            }
        }

        for (int i = 1; i <= 10; i++) {
            for (Method m :
                    methods) {
                if (m.getDeclaredAnnotation(Test.class) != null &&
                        m.getDeclaredAnnotation(Test.class).value() == i) {
                    m.invoke(c, null);
                }
            }
        }

        for (Method m :
                methods) {
            if (m.getDeclaredAnnotation(AfterSuite.class) != null) {
                m.invoke(c, null);
            }
        }

    }

}
