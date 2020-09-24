package blackjack;

import java.util.ArrayList;

public class Hand {
  private ArrayList<Card> cards;

  public Hand() {
    this.cards = new ArrayList<>();
  }

  public void deal(Card card) {
    this.cards.add(card);
  }

  public String getText() {
    String out = "";
    for (Card c : this.cards) {
      out = out + c.getSymbol() + " ";
    }
    return out.stripTrailing();
  }

  public int getValue() {
    int value = 0;
    int aces = 0;
    for (Card c : this.cards) {
      value = value + c.getHighValue();
      if (c.value == Card.ACE) {
        aces = aces + 1;
      }
    }
    while (value > 21 && aces > 0) {
      aces = aces - 1;
      value = value - 10;
    }
    return value;
  }
}