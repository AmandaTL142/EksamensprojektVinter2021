package com.example.eksamensprojektvinter2021.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {

        //Creates db connection and returns as Singleton
        private static String url;
        private static String username;
        private static String password;
        private static Connection conn;

        public JDBC() {
        }

        public static Connection getConnection() {
            if (conn != null) {
                return conn;
            }

            try (InputStream stream = new FileInputStream("src/main/resources/application.properties")) {
                Properties properties = new Properties();
                properties.load(stream);
                url = properties.getProperty("db.url");
                username = properties.getProperty("db.username");
                password = properties.getProperty("db.password");
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connection established");

            } catch (SQLException | IOException e) {
                System.out.println("no connection");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return conn;
        }

}
