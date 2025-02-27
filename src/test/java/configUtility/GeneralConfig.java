package configUtility;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import java.io.File;
import java.io.IOException;

public class GeneralConfig {

    private static final String CONFIG_FILE = "atfConfig.json";

    @SneakyThrows(IOException.class)
    public static <T> T createConfig(Class<T> klass) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(CONFIG_FILE), klass);
    }
}
