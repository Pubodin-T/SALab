import java.util.concurrent.Flow;
import java.util.List;
import java.util.LinkedList;
public class StringPublisher implements Flow.Publisher{

    public List<StringSubscriber> subscribers;

    public StringPublisher(){
        this.subscribers = new LinkedList<>();
    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        if(subscribers.contains(subscriber)){
            subscriber.onError(new IllegalStateException());
        }else{
            var subscription = new StringSubscription(subscriber);
            subscriber.onSubscribe(subscription);
            subscribers.add((StringSubscriber) subscriber);
        }
    }
    

    public void publish(String text){
        for(var sub : subscribers){
            sub.update(text);
        }
    }

    public void close(){
        for(var sub : subscribers){
            sub.writeFile();
        }
    }
}