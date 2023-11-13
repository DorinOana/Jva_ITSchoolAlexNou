package database.queries;

import lombok.SneakyThrows;
import objectData.WebTableObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WebTable extends CommonTable {

    @SneakyThrows(SQLException.class)
    public synchronized void insertTableObject(WebTableObject webTableObject){
        Statement stm = DatabaseConnection.getConnection().createStatement();
        String query = "insert into WebTable(FirstName, LastName, Email, Age, Salary, Department, EntryDate) " +
                "values ('"+webTableObject.getFirstName()+"'," +
                "'"+webTableObject.getLastName()+"'," +
                "'"+ webTableObject.getEmail()+"'," +
                "'"+ webTableObject.getAge()+"'," +
                "'"+ webTableObject.getSalary()+"'," +
                "'"+ webTableObject.getDepartment()+"'," +
                "'"+ getCurrentDateTime()+"');";
        stm.execute(query);
    }

    @SneakyThrows(SQLException.class)
    public synchronized void updateEntryById(Integer idWebTable, WebTableObject webTableObject){
        Statement stm = DatabaseConnection.getConnection().createStatement();
        String query = "update webtable set department='"+webTableObject.getDepartment()+"', " +
                "age='"+webTableObject.getAge()+"' where idWebTable="+idWebTable+";";
        stm.execute(query);
    }

    @SneakyThrows(SQLException.class)
    public synchronized Integer getLatestIdBasedOnEntry(){
        Statement stm = DatabaseConnection.getConnection().createStatement();
        String query = "select idWebTable from webtable order by idWebTable desc limit 1;";
        ResultSet result = stm.executeQuery(query);
        return result.next() ? result.getInt("idWebTable") : 0;
    }
}
