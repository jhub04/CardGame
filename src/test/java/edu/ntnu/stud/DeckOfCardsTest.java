package edu.ntnu.stud;

import edu.ntnu.stud.models.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {
  private DeckOfCards deck;

  @BeforeEach
  void setUp() {
    deck = new DeckOfCards();
  }

  @Test
  void testDeckOfCardsConstructor() {
    assertEquals(52, deck.getAllCards().size());
  }

  @Test
  void testDealHand() {
    List<PlayingCard> hand = deck.dealHand(5);
    assertEquals(5, hand.size());
  }

  @Test
  void testDealHandThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
  }
}
