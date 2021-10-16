import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, ParserConfigurationException, TransformerException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        MappedObject mappedObject = new MappedObject();
        mappedObject.setTitle("encryption");
        mappedObject.setA(1);
        mappedObject.setB("B");
        mappedObject.setC(false);
        mappedObject.setD(4.0);
        MappedObjectHandler mappedObjectHandler = new MappedObjectHandler(mappedObject, documentBuilder, transformer);
        ProgramManager programManager = new ProgramManager(mappedObjectHandler);
        programManager.run();
    }
}
