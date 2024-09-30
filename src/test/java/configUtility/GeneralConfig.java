package configUtility;

import configUtility.xmlNode.Configuration;
import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GeneralConfig {

    @SneakyThrows(JAXBException.class)
    public Configuration createConfig() {
        JAXBContext jaxbContext = JAXBContext.newInstance(Configuration.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Configuration) jaxbUnmarshaller.unmarshal(new File("atfConfig.xml"));
    }
}
