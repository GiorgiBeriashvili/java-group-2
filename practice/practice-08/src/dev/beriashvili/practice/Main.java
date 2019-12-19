package dev.beriashvili.practice;

import java.sql.*;

public class Main {
    private final String url = "jdbc:postgresql://localhost/northwind";
    private final String user = "postgres";
    private final String password = "pass";

    Connection connection;

    public static void main(String[] args) {
        Main main = new Main();
        main.connect();
        main.select();
    }

    public void connect() {
        connection = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public void select() {
        String query = "SELECT * FROM employees;";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(String.format("%s %s", resultSet.getString("first_name"), resultSet.getString("last_name")));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }
}
