package database;

import lombok.SneakyThrows;
import configUtility.GeneralXml;
import configUtility.xmlNode.Configuration;

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
        Configuration configuration = new GeneralXml().createConfig(Configuration.class);
        con = DriverManager.getConnection(getPreparedUrl(configuration), configuration.databaseConfig.username, configuration.databaseConfig.password);
    }

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    private static synchronized String getPreparedUrl(Configuration configuration){
        return "jdbc:mysql://localhost:"+configuration.databaseConfig.port+"/"+configuration.databaseConfig.database+"?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public Connection getConnection() {
        return con;
    }
}
