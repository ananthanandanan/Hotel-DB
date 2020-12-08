package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection;
    public static Connection getConnnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HotelDB","postgres","postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

}

