package edu.ntnu.stud;

import edu.ntnu.stud.models.DeckOfCards;
import edu.ntnu.stud.models.HandOfCards;
import edu.ntnu.stud.models.PlayingCard;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

  private final DeckOfCards deck = new DeckOfCards();

  private HandOfCards currentHand;

  @Override
  public void start(Stage stage) throws Exception {

    // Deal a hand of cards
    List<PlayingCard> hand = deck.dealHand(5);
    currentHand = new HandOfCards(hand);

    // UI for displaying the cards
    HBox cardDisplay = new HBox();
    cardDisplay.setAlignment(Pos.CENTER);
    cardDisplay.setMinSize(500, 150);
    cardDisplay.setMaxSize(500, 150);
    for (PlayingCard card : hand) {
      ImageView imageView = createImageView(card);
      cardDisplay.getChildren().add(imageView);
    }

    // UI for displaying the card stats
    TilePane cardStats = new TilePane();
    cardStats.setAlignment(Pos.CENTER);
    cardStats.setHgap(15);
    cardStats.setVgap(10);
    cardStats.getChildren().add(new Label("Sum of the faces: " + currentHand.calculateSumOfHand()));
    cardStats.getChildren().add(new Label("Number of hearts: " + currentHand.getOnlyHearts()));
    cardStats.getChildren().add(new Label("Flush: " + currentHand.hasFlush()));
    cardStats.getChildren().add(new Label("Queen of spades: " + currentHand.hasQueenOfSpades()));

    // Button for dealing the cards
    Button dealBtn = new Button("Deal hand");
    dealBtn.setOnAction(e -> {
      List<PlayingCard> newHand = deck.dealHand(5);
      currentHand = new HandOfCards(newHand);
      cardDisplay.getChildren().clear();
      cardStats.getChildren().clear();
      for (PlayingCard card : newHand) {
        ImageView imageView = createImageView(card);
        cardDisplay.getChildren().add(imageView);
      }
      cardStats.getChildren().add(new Label("Sum of the faces: " + currentHand.calculateSumOfHand()));
      cardStats.getChildren().add(new Label("Number of hearts: " + currentHand.getOnlyHearts()));
      cardStats.getChildren().add(new Label("Flush: " + currentHand.hasFlush()));
        cardStats.getChildren().add(new Label("Queen of spades: " + currentHand.hasQueenOfSpades()));
    });

    // Layout setup
    VBox root = new VBox(20, cardDisplay, dealBtn, cardStats);
    root.setAlignment(Pos.CENTER);

    // Show the stage
    Scene scene = new Scene(root, 600, 400);
    stage.setTitle("Card Game");
    stage.getIcons().add(new Image("/playing-card.png"));
    stage.setScene(scene);
    stage.show();


  }

  private ImageView createImageView(PlayingCard card) {
    Image image = card.getImage();
    ImageView imageView = new ImageView(image);
    imageView.setFitWidth(100);
    imageView.setFitHeight(150);
    return imageView;
  }

  public static void main(String[] args) {
    launch(args);
  }

}
