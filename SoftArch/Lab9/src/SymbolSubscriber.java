import java.util.concurrent.Flow;
import java.util.jar.Attributes.Name;

public class SymbolSubscriber extends StringSubscriber{

    public SymbolSubscriber(String name) {
        super("symbol", name);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription){
        
    }

    @Override
    public void onNext(String item) {
        // TODO Auto-generated method stub
        if (subTypeSeperator(item)){
            this.writeFile(item);
        }
    }

    @Override
    public void onNext(Object item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean subTypeSeperator(String textInput) {
        // TODO Auto-generated method stub
        return !textInput.matches(".*[a-zA-Z]+[0-9].*");
    }
}
