package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseHandler {
    private String url;
    final private String host = "jdbc:mysql://localhost:3306/";
    final private String settings = "?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private String user;
    private String password;
    private Connection connection;

    public DatabaseHandler(String database, String user, String password) {
        this.url = host + database + settings;
        this.user = user;
        this.password = password;
    }

    public void ChangeInformation(String database, String user, String password) {
        this.url = host + database + settings;
        this.user = user;
        this.password = password;
    }

    public Connection GetConnect() {
        connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch(Exception error) {
            System.out.println("Connection failed: " + error);
        }
        return connection;
    }

    public Statement GetStatement() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (Exception error) {
            System.out.println("Failed: " + error);
        }
        return stmt;
    }

}
