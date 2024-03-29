package edu.ntnu.stud.models;

import java.util.*;
import java.util.stream.Collectors;
import javafx.scene.image.Image;

public class DeckOfCards {

  private final char[] suits = {'S', 'H', 'D',
      'C'}; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
  private List<PlayingCard> allCards;

  public DeckOfCards() {
    this.allCards = new ArrayList<>(52);
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        allCards.add(new PlayingCard(suit, face));
      }
    }
  }

  public List<PlayingCard> getAllCards() {
    return allCards;
  }

  public List<PlayingCard> dealHand(int n) {
    if (n > 52 || n < 1) {
      throw new IllegalArgumentException();
    }
    this.shuffle();
    return allCards.stream()
        .limit(n)
        .collect(Collectors.toList());
  }

  public void shuffle() {
    Collections.shuffle(allCards);
  }

}
