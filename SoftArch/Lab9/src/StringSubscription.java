import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription{

    private StringSubscriber subscriber;
    private boolean completed;

    public StringSubscription(Flow.Subscriber subscriber){

    }

    @Override
    public void request(long n) {
        if(n <= 0){
            subscriber.onError(new IllegalArgumentException());
        }else{
            completed = true;
        }
    }

    @Override
    public void cancel() {
        if(completed){
            completed = false;
            System.out.println("Subsription has expired");
        }
    }
    
}