package database.queries;

import lombok.SneakyThrows;
import objectData.PracticeFormObject;
import objectData.WebTableObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticeFormTable extends CommonTable {

    @SneakyThrows(SQLException.class)
    public synchronized void insertTableObject(PracticeFormObject practiceFormObject){
        Statement stm = DatabaseConnection.getConnection().createStatement();
        String query = "insert into PracticeForm(FirstName, LastName, Email, Gender, Mobile," +
                " DateOfBirth, Subjects, Hobbies, Address, State, City, EntryDate) " +
                "values ('"+practiceFormObject.getFirstName()+"'," +
                "'"+practiceFormObject.getLastName()+"'," +
                "'"+ practiceFormObject.getEmail()+"'," +
                "'"+ practiceFormObject.getGender()+"'," +
                "'"+ practiceFormObject.getMobile()+"'," +
                "'"+ practiceFormObject.getDateOfBirth()+"'," +
                "'"+ practiceFormObject.getSubjects()+"'," +
                "'"+ practiceFormObject.getHobbies()+"'," +
                "'"+ practiceFormObject.getAddress()+"'," +
                "'"+ practiceFormObject.getState()+"'," +
                "'"+ practiceFormObject.getCity()+"'," +
                "'"+ getCurrentDateTime()+"');";
        stm.execute(query);
        System.out.println("S-a executat cu succes query in db");
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
