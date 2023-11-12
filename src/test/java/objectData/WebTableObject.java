package objectData;

import lombok.Data;

import java.util.HashMap;

@Data
public class WebTableObject implements PrepareObject {

    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;
    private Integer webTableEntriesCount;

    public WebTableObject(HashMap<String, String> listValues){
        populateObject(listValues);
    }

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
                case "age":
                    setAge(testData.get(key));
                    break;
                case "salary":
                    setSalary(testData.get(key));
                    break;
                case "department":
                    setDepartment(testData.get(key));
                    break;
            }
        }
    }
}
