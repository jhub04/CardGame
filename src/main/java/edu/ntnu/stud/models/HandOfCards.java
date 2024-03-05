package edu.ntnu.stud.models;

import java.util.List;

public class HandOfCards {
  private List<PlayingCard> hand;

  public HandOfCards(List<PlayingCard> hand) {
    this.hand = hand;
  }

  public int calculateSumOfHand() {
    return hand.stream().mapToInt(PlayingCard::getFace).sum();
  }

  public String getOnlyHearts() {
    return hand.stream()
        .filter(c -> c.getSuit() == 'H')
        .map(PlayingCard::getAsString)
        .reduce("", (a, b) -> a + " " + b);
  }

}
