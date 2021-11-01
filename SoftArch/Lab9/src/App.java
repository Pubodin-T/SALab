public class App {
    public static void main(String[] args) throws Exception {
        
        var publisher = new StringPublisher();
        var alph = new AlphabetSubscriber("alph");
        var number = new NumberSubscriber("number");
        var symbol = new SymbolSubscriber("symbol");

        publisher.subscribe(alph);
        publisher.subscribe(number);
        publisher.subscribe(symbol);

        publisher.publish("Test");
        publisher.publish("SA Lab09");
        publisher.publish("3+6 = 9");
        publisher.publish("So tired!!!!");

        publisher.close();
    }
}
