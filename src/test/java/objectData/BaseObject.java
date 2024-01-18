package objectData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseObject {

    public List<String> getPreparedList(String value){
        String[] splitValues = value.split(",");
        return Arrays.stream(splitValues)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
