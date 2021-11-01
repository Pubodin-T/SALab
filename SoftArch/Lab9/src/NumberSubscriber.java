import java.util.concurrent.Flow;

public class NumberSubscriber extends StringSubscriber{

    public NumberSubscriber(String name){
        super("number", name);
    }

    public  void onSubscribe(Flow.Subscription subscription){

    }

    public void onNext(String item){
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
        return textInput.matches(".*[0-9].*");
    }
}
