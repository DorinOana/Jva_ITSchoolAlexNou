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
    public void updateValuesIntoAzimut(String oldfirstName, String newFirstName){
        Statement stm = DatabaseConnection.getConnection().createStatement();
        String query = "update AzimutVision set FirstName = '"+newFirstName+"' " +
                "where FirstName = '"+oldfirstName+"';";
        stm.execute(query);
    }

    @SneakyThrows(SQLException.class)
    public void selectValuesIntoAzimut(String firstNameValue){
        Statement stm = DatabaseConnection.getConnection().createStatement();
        String query = "select * from AzimutVision where FirstName = '"+firstNameValue+"';";
        ResultSet result = stm.executeQuery(query);
        while (result.next()){
            int id = result.getInt("idAzimut");
            String firstName = result.getString("FirstName");
            String lastName = result.getString("LastName");
            String city = result.getString("City");
            String address = result.getString("Address");
            System.out.println(id + " " +firstName + " "+lastName + " "+ city + " " + address);
        }
    }

    @SneakyThrows(SQLException.class)
    public void deleteValuesIntoAzimut(String firstNameValue){
        Statement stm = DatabaseConnection.getConnection().createStatement();
        String query = "delete from AzimutVision where FirstName = '"+firstNameValue+"';";
        stm.execute(query);
    }
}
