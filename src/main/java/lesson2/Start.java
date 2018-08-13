package lesson2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        try {
            SessionData.connect();
            SessionData.clearDB();
            SessionData.addProducts();

            System.out.println("Введи имя продукта: ");
            Scanner sc = new Scanner(System.in);
            ResultSet resultSet = SessionData.searchProduct(sc.nextLine());
            if (!resultSet.next()) {
                System.out.println("Такого товара нет");
            } else {
                while (resultSet.next()) {
                    System.out.println("цена: " + resultSet.getString(1));
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
