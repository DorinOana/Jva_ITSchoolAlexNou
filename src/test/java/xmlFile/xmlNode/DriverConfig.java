package xmlFile.xmlNode;

import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DriverConfig {

    @XmlElement(name="LocalBrowser")
    public String localBrowser;
    @XmlElement(name="Url")
    public String url;
    @XmlElement(name="Gpu")
    public String gpu;
    @XmlElement(name="Infobars")
    public String infoBars;
    @Setter
    @XmlElement(name="Headless")
    public String headless;
    @XmlElement(name="Extensions")
    public String extensions;
    @XmlElement(name="Resolution")
    public String resolution;
    @XmlElement(name="Sandbox")
    public String sandbox;
}
