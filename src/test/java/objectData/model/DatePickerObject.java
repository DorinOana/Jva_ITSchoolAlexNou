package objectData.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import objectData.BaseObject;

@EqualsAndHashCode(callSuper = true)
@Data
public class DatePickerObject extends BaseObject {

    private String day;
    private String month;
    private String year;
    private String time;

    public DatePickerObject(String filePath){
        fromJsonFile(filePath);
    }
}
