package game.Lines;

/**
 * Hello world!
 *
 */
public class Start {
  public static void main(String[] args) {
    Deck deck = new Deck();
    deck.show();
    deck.click(6, 7);
    deck.show();
    deck.click(2, 3);
    deck.show();
  }
}
