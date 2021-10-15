package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject bookobj;
    private JSONArray  books;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        bookobj = new JSONObject();
        books = new JSONArray();
        bookobj.put("Books",books);
        return null;
        
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        var obj = new JSONObject();
        obj.put("ISBN",b.getISBN());
        obj.put("Title",b.getTitle());
        obj.put("Publisher",b.getPublisher());

        var oBjs = new JSONArray();
        for(var auth : b.getAuthors()){
            oBjs.add(auth);
        }
        obj.put("Authors",oBjs);
        books.add(obj);
        return this;
    }

    @Override
    public String getMetadataString() {
        return bookobj.toString();
    }
}
