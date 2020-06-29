package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please name user: ");
        String name = in.nextLine();
        System.out.println("Please password: ");
        String password = in.nextLine();
        System.out.println("Please database name's: ");
        String dbName = in.nextLine();
        DatabaseHandler handler = new DatabaseHandler(dbName, name, password);
        //Connection conn = handler.ConnectDatabase();
        //Statement st = handler.GetStatement();
    }
}
