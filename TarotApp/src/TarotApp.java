public class TarotApp {
    public static void main(String[] args) throws Exception {
        
        Deck deck = new Deck();
        deck.numberDraw(20);
        deck.shuffleDeck();
        deck.numberDraw(20);
        deck.unshuffleDeck();
        deck.numberDraw(20);
        
    } 
}
