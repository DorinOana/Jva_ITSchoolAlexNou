package xmlFile.xmlNode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="configuration")
public class Configuration {

    @XmlElement(name="DriverConfig")
    public DriverConfig driverConfig;
    @XmlElement(name = "DatabaseConfig")
    public DatabaseConfig databaseConfig;
}
