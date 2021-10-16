import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class MappedObjectHandler {
    private MappedObject mappedObject;
    private JAXBContext jaxbContext;
    private Marshaller marshaller;
    private DocumentBuilder builder;
    private Transformer transformer;

    public MappedObjectHandler(MappedObject mappedObject, DocumentBuilder builder, Transformer transformer) throws JAXBException {
        this.mappedObject = mappedObject;
        this.builder = builder;
        this.transformer = transformer;
        this.jaxbContext = JAXBContext.newInstance(MappedObject.class);
        this.marshaller = jaxbContext.createMarshaller();
    }

    public void printMappedObject() throws JAXBException, TransformerException, IOException, SAXException {
        File file = new File("C:\\Jack\\test.xml");
        Document document = builder.parse(file);
        Element rootElement = document.getDocumentElement();
        appendObjectToBaseElement(rootElement);
        saveToFile(file, document);
    }

    private void saveToFile(File file, Document document) throws TransformerException {
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(file);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(domSource, streamResult);
    }

    private void appendObjectToBaseElement(Element rootElement) throws JAXBException {
        QName qName = new QName(mappedObject.getTitle());
        JAXBElement<MappedObject> objectRootElement = new JAXBElement<MappedObject>(qName, MappedObject.class, mappedObject);
        marshaller.marshal(objectRootElement, rootElement);
    }
}
