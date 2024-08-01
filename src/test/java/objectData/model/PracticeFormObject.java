package objectData.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import objectData.BaseObject;

@EqualsAndHashCode(callSuper = true)
@Data
public class PracticeFormObject extends BaseObject {

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

    public PracticeFormObject(String filePath){
        fromJsonFile(filePath);
    }
}
