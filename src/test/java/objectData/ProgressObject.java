package objectData;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProgressObject extends BaseObject implements PrepareObject {

    private String progressValue;

    public ProgressObject(HashMap<String, String> listValues){
        populateObject(listValues);
    }

    public void populateObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "progressValue":
                    setProgressValue(testData.get(key));
                    break;
            }
        }
    }
}
