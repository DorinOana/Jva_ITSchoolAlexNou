package database;

import lombok.SneakyThrows;
import xmlFile.GeneralXml;
import xmlFile.xmlNode.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;
    private Connection con;

    private DBConnection() {
        createConnection();
    }

    @SneakyThrows(SQLException.class)
    private void createConnection() {
        Configuration configuration = GeneralXml.CreateConfig(Configuration.class);

        String connectionURL = "jdbc:mysql://localhost:"+configuration.databaseConfig.port+"/"+configuration.databaseConfig.database+"?allowPublicKeyRetrieval=true&useSSL=false";
        con = DriverManager.getConnection(connectionURL, configuration.databaseConfig.username, configuration.databaseConfig.password);
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
