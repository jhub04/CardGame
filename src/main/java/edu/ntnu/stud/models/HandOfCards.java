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
    boolean hasHearts = hand.stream().anyMatch(c -> c.getSuit() == 'H');
    if (!hasHearts) {
      return "No hearts";
    }
    return hand.stream()
        .filter(c -> c.getSuit() == 'H')
        .map(PlayingCard::getAsString)
        .reduce("", (a, b) -> a + " " + b);
  }

  public String hasQueenOfSpades() {
    return hand.stream().anyMatch(c -> c.getSuit() == 'S' && c.getFace() == 12) ? "Yes" : "No";
  }

  public String hasFlush() {
    int[] suitCount = new int[4];
    hand.forEach(c -> {
      switch (c.getSuit()) {
        case 'S':
          suitCount[0]++;
          break;
        case 'H':
          suitCount[1]++;
          break;
        case 'D':
          suitCount[2]++;
          break;
        case 'C':
          suitCount[3]++;
          break;
      }
    });
    for (int i : suitCount) {
      if (i >= 5) {
        return "Yes";
      }
    }
    return "No";
  }


}
