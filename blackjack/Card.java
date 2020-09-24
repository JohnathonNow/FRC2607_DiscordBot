package blackjack;

public class Card {
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  public static final int ACE = 14;

  public int value;

  public Card(int value) {
    this.value = value;
  }

  public String getSymbol() {
    if (this.value < Card.JACK) {
      return "" + this.value;
    } else if (this.value == Card.JACK) {
      return "J";
    } else if (this.value == Card.QUEEN) {
      return "Q";
    } else if (this.value == Card.KING) {
      return "K";
    } else if (this.value == Card.ACE) {
      return "A";
    }
    return "";
  }

    public int getHighValue() {
    if (this.value < Card.JACK) {
      return this.value;
    } else if (this.value < Card.ACE) {
      return 10;
    }
    return 11;
  }

}