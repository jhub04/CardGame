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
        Image image = new Image(getClass().getResourceAsStream(
            "/PNG-cards-1.3/" + faceInFull(face) + "_of_" + suitsInFull(suit) + ".png"));
        allCards.add(new PlayingCard(suit, face, image));
      }
    }
  }

  private String faceInFull(int face) {
    switch (face) {
      case 1:
        return "ace";
      case 11:
        return "jack";
      case 12:
        return "queen";
      case 13:
        return "king";
      default:
        return String.valueOf(face);
    }
  }

  private String suitsInFull(char suit) {
    switch (suit) {
      case 'S':
        return "spades";
      case 'H':
        return "hearts";
      case 'D':
        return "diamonds";
      case 'C':
        return "clubs";
      default:
        throw new IllegalArgumentException("Invalid suit");
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
