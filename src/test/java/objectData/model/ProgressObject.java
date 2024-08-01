package objectData.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import objectData.BaseObject;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProgressObject extends BaseObject {

    private String progressValue;

    public ProgressObject(String filePath){
        fromJsonFile(filePath);
    }
}
