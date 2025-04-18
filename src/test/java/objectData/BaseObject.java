package objectData;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;

public class BaseObject {

    @SneakyThrows(IOException.class)
    protected void fromJsonFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readerForUpdating(this).readValue(new File(filePath));
    }
}
