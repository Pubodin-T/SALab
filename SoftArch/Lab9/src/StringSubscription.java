import java.util.concurrent.Flow;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class StringSubscription implements Flow.Subscription{
    private final ExecutorService executor;

	private Flow.Subscriber subscriber;
	private final AtomicInteger value;
	private AtomicBoolean isCanceled;

	private List subscriptions = Collections.synchronizedList(new ArrayList());

	private final CompletableFuture terminated = new CompletableFuture<>();

	private static final String LOG_MESSAGE_FORMAT = "Publisher >> [%s] %s%n";

	public StringSubscription(Flow.Subscriber subscriber, ExecutorService executor) {
		this.subscriber = subscriber;
		this.executor = executor;

		value = new AtomicInteger();
		isCanceled = new AtomicBoolean(false);
	}

    @Override
    public void request(long n) {
        // TODO Auto-generated method stub
        if (isCanceled.get())
			return;

		if (n < 0)
			executor.execute(() -> subscriber.onError(new IllegalArgumentException()));
		else
			publishItems(n);
        
    }

    @Override
    public void cancel() {
        // TODO Auto-generated method stub
        isCanceled.set(true);

		synchronized (subscriptions) {
			subscriptions.remove(this);
			if (subscriptions.size() == 0)
				shutdown();
		}
        
    }
    private void publishItems(long n) {
		for (int i = 0; i < n; i++) {

			executor.execute(() -> {
				int v = value.incrementAndGet();
				log("publish item: [" + v + "] ...");
				subscriber.onNext(v);
			});
		}
	}

	private void shutdown() {
		log("Shut down executor...");
		executor.shutdown();
		newSingleThreadExecutor().submit(() -> {

			log("Shutdown complete.");
			terminated.complete(null);
		});
	}

	private void log(String message, Object... args) {
		String fullMessage = String.format(LOG_MESSAGE_FORMAT, currentThread().getName(), message);

		System.out.printf(fullMessage, args);
	}
    
}
