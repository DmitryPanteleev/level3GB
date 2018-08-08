package lesson1.task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    float weight;
    private ArrayList<T> arr = new ArrayList<>();

    public float getWeight() {
        return arr.size() * weight;//todo
    }

    public void addFruit(T fruit) {
        if (!arr.isEmpty()) {
            if (arr.get(0).getClass() == fruit.getClass()) {
                arr.add(fruit);
            }
        } else {
            arr.add(fruit);
            weight = fruit.getWeight();
        }

    }

    public boolean compare(Box box) {
        return box.getWeight() == this.getWeight();
    }

    public void pepperIn(Box<T> box) {
        for (int i = 0; i < arr.size(); i++) {
            box.addFruit(arr.get(i));
        }
        arr.removeAll(arr);
    }
}
