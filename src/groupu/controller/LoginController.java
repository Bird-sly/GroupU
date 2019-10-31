package groupu.controller;

import groupu.model.Session;
import groupu.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class LoginController {


  private User userStore;

  private static final int width = 325;
  private static final int height = 275;


  @FXML private Button btnRegister;
  @FXML private Button btnLogin;
  @FXML private TextField txtUsername;
  @FXML private TextField txtPassword;

  public void actionLogin(ActionEvent actionEvent) {
    Alert alert;

    String username = txtUsername.getText();
    String pass = txtPassword.getText();

    userStore = new User();

    boolean exists = userStore.checkUserExists(username);
    boolean passMatches = userStore.comparePassword(username, pass);

    if (exists && passMatches) {
      Session session = Session.getInstance(username);
      Utilities.nextScene(btnLogin, "home", "Home - " + username);
    }
    else {
      alert = new Alert(AlertType.ERROR);
      alert.setContentText("Invalid login!");
      alert.show();
    }

  }

  public void actionRegister(ActionEvent actionEvent) {
    Utilities.nextScene(btnRegister, "register", "Register");
  }


}
