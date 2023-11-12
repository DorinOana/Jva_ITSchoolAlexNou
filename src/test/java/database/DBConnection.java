package database;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance; // Singleton instance
    private Connection con;

    private DBConnection() {
        createConnection();
    }

    @SneakyThrows(SQLException.class)
    private void createConnection() {
        String connectionURL = "jdbc:mysql://localhost:3306/itschooldemoqadb?allowPublicKeyRetrieval=true&useSSL=false";
        con = DriverManager.getConnection(connectionURL, "root", "root");
    }

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }
}
