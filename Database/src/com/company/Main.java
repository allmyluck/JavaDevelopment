package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please name user: ");
        String name = in.nextLine();
        System.out.println("Please password: ");
        String password = in.nextLine();
        System.out.println("Please database name's: ");
        String dbName = in.nextLine();
        String firstDB = "CREATE TABLE authors(id INT NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, PRIMARY KEY(id));";
        String secondDB = "CREATE TABLE news(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                " idAuthor INT NOT NULL," +
                " title TEXT, description TEXT, puDate DATETIME, link TEXT," +
                " FOREIGN KEY (idAuthor)  REFERENCES authors(id));";
        DatabaseHandler handler = new DatabaseHandler(dbName, name, password);
        handler.GetConnect();
        Statement st = handler.GetStatement();
        st.executeUpdate(firstDB);
        st.executeUpdate(secondDB);

    }
}
