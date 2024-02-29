module edu.ntnu.stud {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.ntnu.stud to javafx.fxml;
  exports edu.ntnu.stud;
  exports edu.ntnu.stud.view;
  opens edu.ntnu.stud.view to javafx.fxml;
}