package edu.ntnu.stud.utils;

public class CardGameUtils {
  public static String getCardImageFileName(char suit, int face) {
    String suitStr = "";
    switch (suit) {
      case 'S':
        suitStr = "spades";
        break;
      case 'H':
        suitStr = "hearts";
        break;
      case 'D':
        suitStr = "diamonds";
        break;
      case 'C':
        suitStr = "clubs";
        break;
    }

    switch (face) {
      case 1:
        return "/PNG-cards-1.3/" + "ace_of_" + suitStr + ".png";
      case 11:
        return "/PNG-cards-1.3/" + "jack_of_" + suitStr + ".png";
      case 12:
        return "/PNG-cards-1.3/" + "queen_of_" + suitStr + ".png";
      case 13:
        return "/PNG-cards-1.3/" + "king_of_" + suitStr + ".png";
      default:
        return "/PNG-cards-1.3/" + face + "_of_" + suitStr + ".png";
    }
  }
}
