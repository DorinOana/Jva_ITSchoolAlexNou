package objectData.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import objectData.BaseObject;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AlertObject extends BaseObject {

    @JsonProperty("alertValue")
    private String alertValue;

    public AlertObject(String path){
        fromJsonFile(path);
    }
}
