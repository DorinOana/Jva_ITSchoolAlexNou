package database.queries;

import database.DBConnection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonTable {

    public DBConnection DatabaseConnection;

    public CommonTable(){
        DatabaseConnection = DBConnection.getInstance();
    }

    public synchronized String getCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy HH:mm:ss");
        return currentDateTime.format(formatter);
    }
}
