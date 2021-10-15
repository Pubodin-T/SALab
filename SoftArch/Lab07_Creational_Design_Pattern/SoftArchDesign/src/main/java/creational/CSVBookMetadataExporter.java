package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    public CSVBookMetadataExporter(){};

    @Override
    public void export(PrintStream  stream) throws ParserConfigurationException, IOException {
        formatter = new CSVBookMetadataFormatter();
        super.export(stream);
    }
}
