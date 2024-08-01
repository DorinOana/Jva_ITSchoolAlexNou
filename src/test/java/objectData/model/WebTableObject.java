package objectData.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import objectData.BaseObject;

@EqualsAndHashCode(callSuper = true)
@Data
public class WebTableObject extends BaseObject {

    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;
    private Integer webTableEntriesCount;

    public WebTableObject(String filePath){
        fromJsonFile(filePath);
    }
}
