package at.muradundmurad.appdevs.coders318.hstrawberryfields.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label numberStrawberriesLeftLabel;

    @FXML
    private Label pointsPlayer1Label;

    @FXML
    private Label pointsPlayer2Label;

    @FXML
    void initialize() {
        assert numberStrawberriesLeftLabel != null : "fx:id=\"numberStrawberriesLeftLabel\" was not injected: check your FXML file 'game-info-view.fxml'.";
        assert pointsPlayer1Label != null : "fx:id=\"pointsPlayer1Label\" was not injected: check your FXML file 'game-info-view.fxml'.";
        assert pointsPlayer2Label != null : "fx:id=\"pointsPlayer2Label\" was not injected: check your FXML file 'game-info-view.fxml'.";

        pointsPlayer1Label.setText("13");
        pointsPlayer1Label.setText("7");
        numberStrawberriesLeftLabel.setText("0");

    }

}
