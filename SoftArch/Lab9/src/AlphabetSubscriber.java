public class AlphabetSubscriber extends StringSubscriber{
    public AlphabetSubscriber(String name){
        super(name);
        
    }

    public void update(String text){
        if(containAlphabet(text)){
            super.onNext(text);
            System.out.println("Found Alphabet");
        }
    }

    public boolean containAlphabet(String text){
        return text.matches(".*[a-zA-Z]+.*");
    }
}