package configUtility.xmlNode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DatabaseConfig {

    @XmlElement(name="Port")
    public String port;
    @XmlElement(name="Database")
    public String database;
    @XmlElement(name="Username")
    public String username;
    @XmlElement(name="Password")
    public String password;
}
