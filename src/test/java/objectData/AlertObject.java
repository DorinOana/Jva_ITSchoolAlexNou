package objectData;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pages.BasePage;

import java.util.HashMap;

@EqualsAndHashCode(callSuper = true)
@Data
public class AlertObject extends BaseObject implements PrepareObject {

    private String alertValue;

    public AlertObject(HashMap<String, String> listValues){
        populateObject(listValues);
    }

    public void populateObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "alertValue":
                    setAlertValue(testData.get(key));
                    break;
            }
        }
    }
}
