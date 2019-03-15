package perpustakaan.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {

    @FXML
    private JFXTextField username;

    @FXML
    private AnchorPane anchor;

    @FXML
    private JFXPasswordField pass;

    @FXML
    private JFXButton butlogin;

    @FXML
    private JFXButton butbatallogin;

    @FXML
    void batalLogin(ActionEvent event) {

    }

    @FXML
    void tekanLogin(ActionEvent event) throws IOException {
        anchor.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent parent = loader.load();
        anchor.getChildren().add(parent);
    }

}
