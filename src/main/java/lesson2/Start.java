package lesson2;

import java.io.DataOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
/цена PRODUCT1234
/newprice PRODUCT1234 100
/товарыценой 100 500
*/

public class Start {

    private static Scanner sc;

    public static void main(String[] args) {
        try {
            SessionData.connect();
            SessionData.clearDB();
            SessionData.addProducts();

//            System.out.println("Введи имя продукта: ");

            while (true) {
                sc = new Scanner(System.in);
                String string = sc.nextLine();
                System.out.println(string);
                if (string.startsWith("/цена")) {
                    ResultSet resultSet = SessionData.searchProduct(string);
                    if (resultSet.next() == false) {
                        System.out.println("Такого товара нет");
                    } else {
//                        while (resultSet.next()) {
                        System.out.println("цена: " + resultSet.getString(1));
                    }
                } else if (string.startsWith("/newprice")) {
                    SessionData.newPrice(string);
                    System.out.println("цена изменина");

                } else if (string.startsWith("/товарыценой")) {
                    ResultSet rs = SessionData.searchRangeProducts(string);
//                    if (rs.next() == false) {
//                        System.out.println("Таких товаров нет");
//                    } else {
                    Boolean flag = false;//todo
                    while (rs.next()) {
                        System.out.println("Найденные товары: " + rs.getString(1)+ " по цене "
                                + rs.getString(2));
                        flag = true;//костыль
                    }
                    if (rs.next() == false && flag == false) {
                        System.out.println("Таких товаров нет");
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
