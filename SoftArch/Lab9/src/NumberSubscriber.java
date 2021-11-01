public class NumberSubscriber extends StringSubscriber{
    public NumberSubscriber(String name){
        super(name);
        
    }

    public void update(String text){
        if(containNumber(text)){
            super.onNext(text);
            System.out.println("Found Number");
        }
    }

    public boolean containNumber(String text){
        return text.matches(".*[0-9]+.*");
    }
}
