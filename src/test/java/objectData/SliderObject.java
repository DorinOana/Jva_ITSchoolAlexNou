package objectData;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

@EqualsAndHashCode(callSuper = true)
@Data
public class SliderObject extends BaseObject implements PrepareObject {

    private String sliderValue;

    public SliderObject(HashMap<String, String> listValues){
        populateObject(listValues);
    }

    public void populateObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "sliderValue":
                    setSliderValue(testData.get(key));
                    break;
            }
        }
    }
}
