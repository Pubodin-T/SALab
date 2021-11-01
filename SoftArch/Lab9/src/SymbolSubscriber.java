public class SymbolSubscriber extends StringSubscriber{
    public SymbolSubscriber(String name){
        super(name);
        
    }

    public void update(String text){
        if(containSymbol(text)){
            super.onNext(text);
            System.out.println("Found Symbol");
        }
    }

    public boolean containSymbol(String text){
        return text.matches(".*[-+*/%@()!]+.*");
    }
}