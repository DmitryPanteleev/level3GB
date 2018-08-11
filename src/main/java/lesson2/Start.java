package lesson2;

import java.sql.SQLException;

public class Start {
    public static void main(String[] args) {
        try {
            SessionData.connect();
            SessionData.clearDB();
            SessionData.addProducts();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
