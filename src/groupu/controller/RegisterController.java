package groupu.controller;

import java.io.IOException;

import groupu.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

  private static final int width = 325;
  private static final int height = 275;

  private static final int minUsernameSize = 3;
  private static final int minPassSize = 6;

  @FXML private Button btnBack;
  @FXML private TextField txtUsername;
  @FXML private TextField txtFirstname;
  @FXML private TextField txtLastname;
  @FXML private TextField txtPassword;


  public void actionRegister(ActionEvent actionEvent) {
    User user = new User(txtUsername.getText());
    boolean exists = false;

    exists = user.checkUserExists(txtUsername.getText());

    if (!exists && txtFirstname.getLength() > 0 && txtLastname.getLength() > 0 &&
        txtUsername.getLength() >= minUsernameSize && txtPassword.getLength() > minPassSize) {

      user.createUser(txtFirstname.getText(), txtLastname.getText(),
         txtUsername.getText(), txtPassword.getText());

      actionBack(actionEvent);
    } else {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setContentText("Username already exists or invalid information!");
      alert.show();
    }
  }

  public void actionBack(ActionEvent actionEvent) {
    Utilities.nextScene(btnBack, "login", "Login");
  }
}
