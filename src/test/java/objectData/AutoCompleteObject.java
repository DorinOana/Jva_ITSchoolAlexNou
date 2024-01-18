package objectData;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AutoCompleteObject extends BaseObject implements PrepareObject{

    private List<String> multipleColors;
    private String singleColor;

    public AutoCompleteObject(HashMap<String, String> listValues){
        populateObject(listValues);
    }

    @Override
    public void populateObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "multipleColors":
                    multipleColors = getPreparedList(testData.get(key));
                    break;
                case "singleColor":
                    setSingleColor(testData.get(key));
                    break;
            }
        }
    }
}
