package xmlFile;

import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class GeneralXml {

    @SneakyThrows(JAXBException.class)
    public <T> T createConfig(Class<T> klass)  {
        JAXBContext jaxbContext = JAXBContext.newInstance(klass);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return klass.cast(jaxbUnmarshaller.unmarshal(new File("src/test/resources/commonData/shareDataConfig.xml")));
    }
}
