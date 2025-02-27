package configUtility.xmlNode;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

public class DriverConfig {
    @JsonProperty("LocalBrowser")
    public String localBrowser;
    @JsonProperty("Url")
    public String url;
    @JsonProperty("Gpu")
    public String gpu;
    @JsonProperty("Infobars")
    public String infoBars;
    @Setter
    @JsonProperty("Headless")
    public Boolean headless;
    @JsonProperty("Extensions")
    public String extensions;
    @JsonProperty("Resolution")
    public String resolution;
    @JsonProperty("Sandbox")
    public String sandbox;
    @JsonProperty("BrowserCheck")
    public String browserCheck;
    @JsonProperty("DevShm")
    public String devShm;
    @JsonProperty("SearchEngine")
    public String searchEngine;
}
