package database;

import lombok.SneakyThrows;
import configUtility.GeneralConfig;
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
        Configuration configuration = new GeneralConfig().createConfig();
        con = DriverManager.getConnection(getPreparedUrl(configuration), configuration.databaseConfig.username, configuration.databaseConfig.password);
    }

    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    private static String getPreparedUrl(Configuration configuration){
        String ci_cd = System.getProperty("ci_cd");
        if (Boolean.parseBoolean(ci_cd)){
            return "jdbc:mysql://"+configuration.databaseConfig.remoteServer+":"+configuration.databaseConfig.port+"/"+configuration.databaseConfig.database+"?allowPublicKeyRetrieval=true&useSSL=false";
        } else {
            return "jdbc:mysql://localhost:"+configuration.databaseConfig.port+"/"+configuration.databaseConfig.database+"?allowPublicKeyRetrieval=true&useSSL=false";
        }
    }

    public Connection getConnection() {
        return con;
    }
}
