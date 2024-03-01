package edu.ntnu.stud.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Stage stage = new Stage();

    Group root = new Group();
    Scene scene = new Scene(root, Color.WHITE);

    Image icon = new Image("/playing-card.png");

    primaryStage.getIcons().add(icon);
    primaryStage.setWidth(1200);
    primaryStage.setHeight(900);
    primaryStage.setResizable(false);
    primaryStage.setTitle("CardGame");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
