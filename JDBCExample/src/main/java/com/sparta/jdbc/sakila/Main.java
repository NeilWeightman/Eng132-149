package com.sparta.jdbc.sakila;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileReader("dbconnect.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Connection conn = DriverManager.getConnection(
                props.getProperty("mysql.url"),
                props.getProperty("mysql.username"),
                props.getProperty("mysql.password"))) {
            // avoids SQL injection attacks
            PreparedStatement statement = conn.prepareStatement(
                    "SELECT * FROM actor WHERE last_name = ?");
            statement.setString(1, "COSTNER");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(2) + " "
                        + rs.getString("last_name"));
            }
            conn.setAutoCommit(false);
            PreparedStatement insertStatement = conn.prepareStatement(
                    "INSERT INTO actor (first_name, last_name)" +
                    "VALUES (?, ?)");
            insertStatement.setString(1, "Ali");
            insertStatement.setString(2, "Zahir");
            int rowsUpdated = insertStatement.executeUpdate();
            insertStatement.setString(1, "Daniel");
            insertStatement.setString(2, "Nenov");
            rowsUpdated = insertStatement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}