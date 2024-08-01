package objectData.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import objectData.BaseObject;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AutoCompleteObject extends BaseObject {

    private List<String> multipleColors;
    private String singleColor;

    public AutoCompleteObject(String filePath){
        fromJsonFile(filePath);
    }
}
