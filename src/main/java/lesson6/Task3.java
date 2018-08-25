package lesson6;

import java.sql.*;
import java.util.ArrayList;

public class Task3 {

    private Connection connection;
    private Statement stmt;

    public Task3() {
        try {
            connect();
            System.out.println("connect");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws SQLException {
//        Task3 task3 = new Task3();
////        for (int i = 0; i < 25; i++) {
////            task3.addStudent("student" + i, (int) ( 1+(Math.random()*i)));
////        }
//    }

    public ArrayList selectAllStudents() {
        String sql = String.format("SELECT last_name, score FROM students");
        ResultSet rs = null;
        ArrayList arrayList = new ArrayList();
        arrayList = getArraylist(sql, arrayList);
        return arrayList;
    }

    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("JDBC:sqLite:studentsDB.db");
        stmt = connection.createStatement();
    }

    public void addStudent(String last_name, int score) {
        String sql = String.format("INSERT INTO students (last_name, score) VALUES('%S','%d')", last_name, score);
//        System.out.println(sql);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList selectStudent(String last_name) {
        String sql = String.format("SELECT last_name, score FROM students " +
                "WHERE last_name = '%S';", last_name);
        ArrayList arrayList = new ArrayList();
        ResultSet rs = null;
        arrayList = getArraylist(sql, arrayList);
        return arrayList;
    }

    public void updateScore(String last_name, int newScore) {
        String sql = String.format("UPDATE students SET score = '%d' WHERE last_name = '%S';", newScore, last_name);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String last_name) {
        String sql = String.format("DELETE FROM students WHERE last_name = '%S'", last_name);
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ArrayList getArraylist(String sql, ArrayList arrayList) {
        ResultSet rs;
        try {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                arrayList.add(rs.getString(1) + " " + rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
