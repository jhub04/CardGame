package edu.ntnu.stud.models;

import java.io.InputStream;
import javafx.scene.image.Image;

/**
 * Represents a playing card. A playing card has a number (face) between 1 and 13, where 1 is called
 * an Ace, 11 = Knight, 12 = Queen and 13 = King. The card can also be one of 4 suits: Spade, Heart,
 * Diamonds and Clubs.
 *
 * @author ntnu
 * @version 2021-03-13
 */
public class PlayingCard {

  private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
  private final int face; // a number between 1 and 13

  private final Image image;

  /**
   * Creates an instance of a PlayingCard with a given suit and face. The face value is an integer
   * between 1 and 13, where 11 represents the jack, 12 represents the queen and 13 represents the
   * king. The Ace is represented by the number 1.
   *
   * <p>If the suit or face are invalid, an {@code IllegalArgumentException} is thrown.</p>
   *
   * @param suit The suit of the card, as a single character. 'S' for Spades, 'H' for Heart, 'D' for
   *             Diamonds and 'C' for clubs
   * @param face The face value of the card, an integer between 1 and 13
   * @throws IllegalArgumentException if suit or face have invalid values.
   */
  public PlayingCard(char suit, int face, Image image) {
    if (suit != 'H' && suit != 'D' && suit != 'C' && suit != 'S') {
      throw new IllegalArgumentException("Parameter suit must be one of H, D, C or S");
    }

    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Parameter face must be a number between 1 to 13");
    }

    this.suit = suit;
    this.face = face;
    String imageName = "/PNG-cards-1.3/" + faceInFull() + "_of_" + suitsInFull() + ".png";
    InputStream is = getClass().getResourceAsStream(imageName);
    if (is == null) {
      throw new IllegalArgumentException("Cannot find image file: " + imageName);
    }
    this.image = new Image(is);
  }

  /**
   * Returns the suit and face of the card as a string. A 4 of hearts is returned as the string
   * "H4".
   *
   * @return the suit and face of the card as a string
   */
  public String getAsString() {
    return String.format("%s%s", suit, face);
  }

  /**
   * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for
   * clubs.
   *
   * @return the suit of the card
   */
  public char getSuit() {
    return suit;
  }

  /**
   * Returns the face of the card (value between 1 and 13).
   *
   * @return the face of the card
   */
  public int getFace() {
    return face;
  }

  public Image getImage() {
    return image;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayingCard otherCard = (PlayingCard) o;
    return getSuit() == otherCard.getSuit() && getFace() == otherCard.getFace();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + getSuit();
    hash = 31 * hash + getFace();
    return hash;
  }

  public String suitsInFull() {
    if (suit == 'H') {
      return "hearts";
    } else if (suit == 'D') {
      return "diamonds";
    } else if (suit == 'C') {
      return "clubs";
    } else {
      return "spades";
    }
  }

  public String faceInFull() {
    if (face == 1) {
      return "ace";
    } else if (face == 11) {
      return "jack";
    } else if (face == 12) {
      return "queen";
    } else if (face == 13) {
      return "king";
    } else {
      return String.valueOf(face);
    }
  }
}
