import java.util.concurrent.Flow;
import java.util.ArrayList;
import java.util.concurrent.Flow.Subscriber;

public class StringPublisher implements Flow.Publisher {

	private ArrayList<StringSubscriber> subscriptions;
	private boolean isSub;

	public StringPublisher(){
		this.subscriptions = new ArrayList<StringSubscriber>();
	}

	@Override
	public void subscribe(Flow.Subscriber subscriber) {
		if (isSub) {
			subscriber.onError(new IllegalArgumentException());
		} else {
			isSub = true;
		}
	}

	public void addSub(StringSubscriber subs){
		this.subscriptions.add(subs);
	}

	public void publish(String word) {
		System.out.println("Input Text: " + word);
		for (StringSubscriber i : subscriptions) {
			i.onNext(word);
		}
	}
}