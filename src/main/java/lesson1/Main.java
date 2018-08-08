package lesson1;

import lesson1.task3.Apple;
import lesson1.task3.Box;
import lesson1.task3.Orange;

public class Main {

    public static void main(String[] args) {
// #1
        String[] str = {"str1", "str2", "str3", "str4", "str5", "str6"};
        Integer[] integers ={1,2,3,4,5,6};
        try {
            Task1 work1 = new Task1(str, 1, 4);
            Task1 work12 = new Task1(integers, 1, 4);

        } catch (Exception e) {
            e.printStackTrace();
        }

//  #2
        Task2 task2 = new Task2(str);
        Task2 task22 = new Task2(integers);


//  #3

        Box appleBox = new Box<Apple>();
        appleBox.addFruit(new Orange());

    }

}
