package objectData;

import lombok.Data;

import java.util.HashMap;

@Data
public class AlertObject implements PrepareObject {

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
