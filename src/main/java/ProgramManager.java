import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;

public class ProgramManager {
    private MappedObjectHandler mappedObjectHandler;

    public ProgramManager(MappedObjectHandler mappedObjectHandler) {
        this.mappedObjectHandler = mappedObjectHandler;
    }

    public void run() throws JAXBException, TransformerException, IOException, SAXException {
        int userInput = 0;
        Scanner scanner = new Scanner(System.in);

        while(userInput != -1) {
            System.out.println("Enter -1 to finish, anything else to continue");
            userInput = scanner.nextInt();
            runProgram();
        }
    }

    private void runProgram() throws JAXBException, TransformerException, IOException, SAXException {
        mappedObjectHandler.printMappedObject();
    }
}
