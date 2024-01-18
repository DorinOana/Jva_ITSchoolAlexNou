package objectData;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

@EqualsAndHashCode(callSuper = true)
@Data
public class DatePickerObject extends BaseObject implements PrepareObject {

    private String day;
    private String month;
    private String year;
    private String time;

    public DatePickerObject(HashMap<String, String> listValues){
        populateObject(listValues);
    }

    public void populateObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "day":
                    setDay(testData.get(key));
                    break;
                case "month":
                    setMonth(testData.get(key));
                    break;
                case "year":
                    setYear(testData.get(key));
                    break;
                case "time":
                    setTime(testData.get(key));
                    break;
            }
        }
    }
}
