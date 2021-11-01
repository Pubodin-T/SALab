import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber {
    public AlphabetSubscriber(String name){
        super("alphabet", name);
    }

    public void onSubscribe(Flow.Subscription subscription){

    }

    @Override
    public void onNext(String item){
        if (subTypeSeperator(item)){
            this.writeFile(item);
        }
    }
    
    @Override
    public boolean subTypeSeperator(String textInput) {
        // TODO Auto-generated method stub
        return textInput.matches(".*[a-zA-Z]+.*");
    }

    @Override
    public void onNext(Object item) {
        // TODO Auto-generated method stub
        
    }
}
