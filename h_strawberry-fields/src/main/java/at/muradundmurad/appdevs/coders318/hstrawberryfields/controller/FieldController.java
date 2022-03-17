package at.muradundmurad.appdevs.coders318.hstrawberryfields.controller;

import java.net.URL;
import java.util.ResourceBundle;

import at.muradundmurad.appdevs.coders318.hstrawberryfields.Constants;
import at.muradundmurad.appdevs.coders318.hstrawberryfields.model.Field;
import at.muradundmurad.appdevs.coders318.hstrawberryfields.model.Square;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FieldController extends BaseController {


    private static final Logger log = LoggerFactory.getLogger(FieldController.class);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane fieldView;

    private Field field = game.getField();

    @FXML
    void initialize() {
        assert fieldView != null : "fx:id=\"fieldView\" was not injected: check your FXML file 'field-view.fxml'.";

        fieldView.add(new Button("Hello"), 3, 4);

        // Figur von Position A wegnehmen
        StackPane firstSquareView = (StackPane) fieldView.getChildren().get(0);
        ImageView itemView = (ImageView) firstSquareView.getChildren().get(0);
        firstSquareView.getChildren().clear();

        // und auf Position B ziehen
        StackPane secondSquareView = (StackPane) fieldView.getChildren().get(1);
        secondSquareView.getChildren().add(itemView);

        // field neu erstellen
        generateSquares();

        // items hinzufügen
        updateSquares();

        // item bewegen
        field.getSquares().get(0).setItem("");
        updateSquareAtIndex(0);

        field.getSquares().get(1).setItem("p");
        updateSquareAtIndex(1);

        // key event handler registrieren
        fieldView.setOnKeyPressed(this::onKeyPressed);

        // focus setzen
        fieldView.sceneProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                fieldView.requestFocus();
            }
        });

        // listener auf Veränderungen im field-squares
        field.getSquares().addListener(new ListChangeListener<Square>() {
            @Override
            public void onChanged(Change<? extends Square> c) {

                while(c.next()) {
                    if (c.wasUpdated()) {

                        updateSquareAtIndex(c.getFrom());
                    }
                }
            }
        });

        // test if listener us working
        field.getSquares().get(0).setItem("P");

    }

    private void updateSquareAtIndex(int squareIndex) {

        ImageView itemView = null;


        if (squareIndex < field.getSquares().size()) {
            String item = field.getSquares().get(squareIndex).getItem();
            Image image = imageForItem(item);
            itemView = new ImageView(image);
            itemView.setPreserveRatio(true);
            itemView.setFitHeight(50);
        }

        if (fieldView.getChildren().get(squareIndex) instanceof StackPane squareView) {
            squareView.getChildren().clear();

            if (itemView != null) {
                squareView.getChildren().add(itemView);
            }
        }
    }

    private void updateSquares() {

        for (int rowIndex = 0; rowIndex < Field.NUMBER_ROWS; rowIndex++) {

            for (int colIndex = 0; colIndex < Field.NUMBER_COLS; colIndex++) {

                int squareIndex = rowIndex + colIndex;
                updateSquareAtIndex(squareIndex);
            }
        }
    }

    private void generateSquares() {

        fieldView.getChildren().clear();

        for (int rowIndex = 0; rowIndex < Field.NUMBER_ROWS; rowIndex++) {

            for (int colIndex = 0; colIndex < Field.NUMBER_COLS; colIndex++) {

                StackPane squareView = new StackPane();
                squareView.getStyleClass().add("square-view");
                fieldView.add(squareView, colIndex, rowIndex);
            }

        }
    }

    private Image imageForItem(String item) {

        String pathToPNG = switch (item) {
            case "s" -> Constants.PATH_TO_STRAWBERRY_PNG;
            case "p" -> Constants.PATH_TO_PLAYER_FEMALE_PNG;
            case "P" -> Constants.PATH_TO_PLAYER_MALE_PNG;
            default -> "";
        };

        return new Image(getClass().getResourceAsStream(pathToPNG));
    }

    private void onKeyPressed(KeyEvent event) {

        KeyCode key = event.getCode();
        game.handleKeyPressed(key);

//        log.info("Key pressed: {}", event.getText());
    }

    private void moveRight() {

        String item = field.getSquares().get(0).getItem();
        field.getSquares().get(0).setItem("");
        field.getSquares().get(1).setItem(item);
    }

}
