package edu.ntnu.stud;

import edu.ntnu.stud.models.DeckOfCards;
import edu.ntnu.stud.models.PlayingCard;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

  private DeckOfCards deck = new DeckOfCards();

  @Override
  public void start(Stage stage) throws Exception {

    // UI for displaying the cards
    HBox cardDisplay = new HBox();
    cardDisplay.setAlignment(Pos.CENTER);

    // Button for dealing the cards
    Button dealBtn = new Button("Deal hand");
    dealBtn.setOnAction(e -> {
      List<PlayingCard> hand = deck.dealHand(5);
      cardDisplay.getChildren().clear();
      for (PlayingCard card : hand) {
        ImageView imageView = createImageView(card);
        cardDisplay.getChildren().add(imageView);
      }
    });


    // Layout setup
    VBox root = new VBox(20, cardDisplay, dealBtn);
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
