package objectData;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectMenuObject extends BaseObject implements PrepareObject{

    private List<String> multiSelect;
    private String selectValue;
    private String oldStyleMenu;
    private String selectOne;

    public SelectMenuObject(HashMap<String, String> listValues){
        populateObject(listValues);
    }

    @Override
    public void populateObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "multiSelect":
                    multiSelect = getPreparedList(testData.get(key));
                    break;
                case "selectValue":
                    setSelectValue(testData.get(key));
                    break;
                case "oldStyleMenu":
                    setOldStyleMenu(testData.get(key));
                    break;
                case "selectOne":
                    setSelectOne(testData.get(key));
                    break;
            }
        }
    }
}
