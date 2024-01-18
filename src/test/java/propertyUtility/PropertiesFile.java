package propertyUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesFile {

    private Properties properties;

    public PropertiesFile(String fileName){
        loadFile(fileName);
    }

    private void loadFile(String fileName){
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/" + fileName + ".properties");
            properties.load(fileInputStream);
        }
        catch (IOException ignored){
        }
    }

    public HashMap<String, String> getAllValues(){
        HashMap<String, String> map = new HashMap<>();
        for (String key : properties.stringPropertyNames()) {
            map.put(key, properties.getProperty(key));
        }
        return map;
    }
}
