package lesson2;

import java.sql.*;


// чтобы узнать цену напиши "/цена PRODUCT1234"

public class SessionData {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("JDBC:sqLite:lessonDB.db");
        String sql = "CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "prodID TEXT UNIQUE," +
                "title TEXT," +
                "cost INTEGER);";
        System.out.println(sql);
        stmt = connection.createStatement();
        stmt.executeUpdate(sql);

    }

    public static void clearDB() throws SQLException {
        stmt.executeUpdate("DELETE FROM products;");
    }

    public static void addProducts() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++) {
            String sql = String.format("INSERT INTO products (prodID, title, cost)" +
                    "VALUES(\'%S\', \'%S\', \'%d\')", "productID" + i, "product" + i, i);
            stmt.executeUpdate(sql);
        }
        connection.setAutoCommit(true);
    }

    public static ResultSet searchProduct(String product) throws SQLException {
        String[] strings = product.split(" ", 2);
        String products = strings[1];
//        System.out.println(products);
        String sql = String.format("SELECT cost FROM products WHERE title = '%S'", products);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public static int newPrice(String newPriceProduct) throws SQLException {

        String[] strings = newPriceProduct.split(" ", 3);
        String product = strings[1];
        String newPrice = strings[2];
        String sql = String.format("UPDATE products SET cost = '%S' WHERE title = '%S';", newPrice, product);
        System.out.println(sql);
        int i = stmt.executeUpdate(sql);
        return i;
    }

    public static ResultSet searchRangeProducts(String productRange) throws SQLException {
        String[] strings = productRange.split(" ", 3);
        String price1 = strings[1];
        String price2 = strings[2];
        String sql = String.format("SELECT title FROM products WHERE cost >= '%S' AND cost <= '%S' ;", price1, price2);
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

}
