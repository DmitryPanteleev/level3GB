package lesson1;

import lesson1.task3.Apple;
import lesson1.task3.Box;
import lesson1.task3.Orange;

public class Main {

    public static void main(String[] args) {
        String[] str = {"str1", "str2", "str3", "str4", "str5", "str6"};
        Integer[] integers ={1,2,3,4,5,6};
// #1
        try {
            new Task1(str, 1, 4);
            new Task1(integers, 1, 4);

        } catch (Exception e) {
            e.printStackTrace();
        }

//  #2
        new Task2(str);
        new Task2(integers);


//  #3

        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 100; i++) {
            appleBox.addFruit(new Apple());
        }
        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 150; i++) {
            appleBox2.addFruit(new Apple());
        }
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 100; i++) {
            orangeBox.addFruit(new Orange());
        }
//        Box<Orange> orangeBox2 = new Box<>();
//        for (int i = 0; i < 100; i++) {
//            orangeBox2.addFruit(new Apple());
//        }

        System.out.println("apple weight " + appleBox.getWeight());
        System.out.println("apple2 weight " + appleBox2.getWeight());
        System.out.println("orange weight " + orangeBox.getWeight());
        System.out.println("сравниваем вес коробок яблок " + appleBox.compare(orangeBox));
        System.out.println("сравниваем вес коробок апельсин и яблок " + orangeBox.compare(appleBox2));

        appleBox.pepperIn(appleBox2);
//        appleBox.pepperIn(orangeBox);

        System.out.println("В первой коробке стало " + appleBox.getWeight());
        System.out.println("Во второй коробке стало " + appleBox2.getWeight());

    }

}
