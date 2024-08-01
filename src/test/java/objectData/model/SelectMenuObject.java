package objectData.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import objectData.BaseObject;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SelectMenuObject extends BaseObject {

    private List<String> multiSelect;
    private String selectValue;
    private String oldStyleMenu;
    private String selectOne;

    public SelectMenuObject(String filePath){
        fromJsonFile(filePath);
    }

}
