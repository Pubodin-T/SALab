package creational;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public class JSONBookMetadataExporter extends BookMetadataExporter{
    public JSONBookMetadataExporter(){};

    @Override
    public void export(PrintStream  stream) throws ParserConfigurationException, IOException {
        formatter = new JSONBookMetadataFormatter();
        super.export(stream);
    }
}
