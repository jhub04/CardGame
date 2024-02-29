module edu.ntnu.stud {
  requires javafx.controls;
  requires javafx.fxml;

  opens edu.ntnu.stud to javafx.fxml;
  exports edu.ntnu.stud;
}