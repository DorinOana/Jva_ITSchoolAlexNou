package database.queries;

import lombok.SneakyThrows;
import objectData.PracticeFormObject;

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
    }
}
