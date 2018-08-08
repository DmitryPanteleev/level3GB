package lesson1.task3;

import java.util.ArrayList;

public class Box<T> {


    private ArrayList<T> arr = new ArrayList<T>();

    public int getWeight() {
        return arr.size() ;//todo
    }

    public void addFruit(T fruit) {
        arr.add(fruit);
    }
}
