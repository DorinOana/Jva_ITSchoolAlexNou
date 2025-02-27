package configUtility.xmlNode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Configuration {
    @JsonProperty("DriverConfig")
    public DriverConfig driverConfig;
    @JsonProperty("DatabaseConfig")
    public DatabaseConfig databaseConfig;
}
