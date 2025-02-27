package configUtility.xmlNode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DatabaseConfig {
    @JsonProperty("Port")
    public String port;
    @JsonProperty("Database")
    public String database;
    @JsonProperty("Username")
    public String username;
    @JsonProperty("Password")
    public String password;
    @JsonProperty("RemoteServer")
    public String remoteServer;
}
