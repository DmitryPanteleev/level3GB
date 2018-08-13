package lesson2;

import java.sql.*;

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
                    "VALUES(\'%S\', \'%S\', \'%d\')","productID" + i, "product" + i, i);
            stmt.executeUpdate(sql);
        }
        connection.setAutoCommit(true);
    }

    public static ResultSet searchProduct(String product) throws SQLException {
        String sql = String.format("SELECT cost FROM products WHERE title = '%S'", product);
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }


}
