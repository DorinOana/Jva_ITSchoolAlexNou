package objectData.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import objectData.BaseObject;

@EqualsAndHashCode(callSuper = true)
@Data
public class SliderObject extends BaseObject {

    private String sliderValue;

    public SliderObject(String filePath){
        fromJsonFile(filePath);
    }
}
