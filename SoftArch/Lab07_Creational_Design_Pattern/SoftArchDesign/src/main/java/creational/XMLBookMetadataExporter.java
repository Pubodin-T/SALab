package creational;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;
public class XMLBookMetadataExporter extends BookMetadataExporter{
    public  XMLBookMetadataExporter(){};

    @Override
    public void export(PrintStream  stream) throws ParserConfigurationException, IOException {
        formatter = new XMLBookMetadataFormatter();
        super.export(stream);
    }
}
