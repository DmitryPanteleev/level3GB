package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2<T> {

    private T[] mass;
    private ArrayList arr = new ArrayList();

    public Task2(T[] mass) {
        this.mass = mass;
        createArrList();
    }

    private void createArrList() {

        arr.addAll(Arrays.asList(mass));

        System.out.println(arr);
    }
}
