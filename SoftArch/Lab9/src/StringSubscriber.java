import java.util.LinkedList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StringSubscriber implements Flow.Subscriber{
    private String subscriberType;
	private String subscriberName;
	private String wordTemp;
    

    public StringSubscriber(){};
    public StringSubscriber(String subType, String subName){
		this.subscriberType = subType;
		this.subscriberName = subName;
		//init Text file
		try {
			File myObj = new File(this.subscriberName +".txt");
			if (myObj.createNewFile()) {
			  System.out.println("File created: " + myObj.getName());
			} else {
			  System.out.println("File already exists.");
			  wordTemp = new String(Files.readAllBytes(Path.of(this.subscriberName+".txt")));
			}
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	}
    public void writeFile(String word){
		try {
			FileWriter myWriter = new FileWriter(this.subscriberName + ".txt");
			myWriter.write(wordTemp + word + "\n");
			myWriter.close();
			this.onComplete();
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			this.onError(e);
		  }
        }

    public boolean subTypeSeperator(String textInput) {
        return false;
    }

	public void onSubscribe(Flow.Subscription subscription) {
    }

	public void onNext(String item) {
    }



    @Override
    public void onError(Throwable throwable) {
        // TODO Auto-generated method stub
        throwable.printStackTrace();
        
    }

    @Override
    public void onComplete() {
        // TODO Auto-generated method stub
        System.out.println("Complete!");
        
    }
    @Override
    public void onNext(Object item) {
        // TODO Auto-generated method stub
        
    }
    
}
