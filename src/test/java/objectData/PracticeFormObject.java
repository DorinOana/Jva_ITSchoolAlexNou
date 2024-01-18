package objectData;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@EqualsAndHashCode(callSuper = true)
@Data
public class PracticeFormObject extends BaseObject implements PrepareObject {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String dateOfBirth;
    private String subjects;
    private String hobbies;
    private String address;
    private String state;
    private String city;

    public PracticeFormObject(HashMap<String, String> listValues){
        populateObject(listValues);
        prepareDateOfBirth();
    }

    @Override
    public void populateObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "firstName":
                    setFirstName(testData.get(key));
                    break;
                case "lastName":
                    setLastName(testData.get(key));
                    break;
                case "email":
                    setEmail(testData.get(key));
                    break;
                case "gender":
                    setGender(testData.get(key));
                    break;
                case "mobile":
                    setMobile(testData.get(key));
                    break;
                case "dateOfBirth":
                    setDateOfBirth(testData.get(key));
                    break;
                case "subjects":
                    setSubjects(testData.get(key));
                    break;
                case "hobbies":
                    setHobbies(testData.get(key));
                    break;
                case "address":
                    setAddress(testData.get(key));
                    break;
                case "state":
                    setState(testData.get(key));
                    break;
                case "city":
                    setCity(testData.get(key));
                    break;
            }
        }
    }

    private void prepareDateOfBirth(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy");
        String formattedDate = currentDate.format(formatter);
        setDateOfBirth(formattedDate);
    }
}
