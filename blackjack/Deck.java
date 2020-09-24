package blackjack;


import java.util.Collections;
import java.util.ArrayList;

public class Deck {
  private ArrayList<Card> cards;
  private int count;
  
  public Deck(int count) {
    this.cards = new ArrayList<Card>();
    this.count = count;
    this.reset();
  }

  public void shuffle() {
    Collections.shuffle(this.cards);
  }

  public Card draw() {
    return this.cards.remove(0);
  }

  public void reset() {
    this.cards.clear();
    int i = 0;
    while (i < this.count) {
      i = i + 1;
      int card = 2;
      while (card <= Card.ACE) {
        this.cards.add(new Card(card));
        card = card + 1;
      }
    }
  }
}