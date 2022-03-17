package at.muradundmurad.appdevs.coders318.i_strawberryfields;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class FieldController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane fieldView;

    // Model, das die Daten liefert
    private Field field = new Field();

    @FXML
    void initialize() {
        assert fieldView != null : "fx:id=\"fieldView\" was not injected: check your FXML file 'field-view.fxml'.";

        initField();

        field.getSquares().addListener(new ListChangeListener<Square>() {
            @Override
            public void onChanged(Change<? extends Square> c) {

                while(c.next()) {

                    if (c.wasUpdated()) {
                        // c.from() liefert index von verändertem Square
                        System.out.println("Updated: " + c.getFrom());
                        updateSquare(c.getFrom());
                    }
                }
            }
        });
//
//        updateSquare(12);
//
//        updateSquare(10);
    }

    /**
     * Fill the grid pane with StackPanes
     */
    private void initField() {

        // alle statisch definierten Kindknoten entfernen
        fieldView.getChildren().clear();

        for (int rowIndex=0; rowIndex<Constants.NUMBER_ROWS; rowIndex++) {

            for (int colIndex=0; colIndex<Constants.NUMBER_COLS; colIndex++) {

                StackPane squareView = new StackPane();
                squareView.getStyleClass().add("square-view");
                fieldView.add(squareView, colIndex, rowIndex);

                // FIXME: Hier zu beginn updaten
                int index = colIndex + (Constants.NUMBER_COLS)*rowIndex;
                updateSquare(index);
            }
        }
    }

    /**
     * Entfernt den ImageView im Square View an der Stelle index und
     * Fügt ein neues ImageView ein.
     * @param index
     */
    private void updateSquare(int index) {

        if (fieldView.getChildren().get(index) instanceof StackPane) {
            StackPane squareView = (StackPane) fieldView.getChildren().get(index);

            // imageView immer zuerst entfernen
            squareView.getChildren().clear();

            // Je nachdem welches Item im Model an dieser Position liegt, wird
            // das passende Bild ausgewählt
            String item = field.getSquares().get(index).getItem();
            // FIXME: überprüfen ob item vorhanden
            if (item != null) {
                Image image = imageForItem(item);
                ImageView imageView = new ImageView(image);
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(50);
                squareView.getChildren().add(imageView);
            }
        }
    }

    /**
     * Lädt je nach Item ein anderes Bild
     * @param item
     * @return
     */
    private Image imageForItem(String item) {

        /* P, p, s */
        String path = switch (item) {
            case Constants.PERSON_FEMALE -> Constants.PATH_TO_FEMALE_PLAYER_PNG;
            case Constants.PERSON_MALE -> Constants.PATH_TO_MALE_PLAYER_PNG;
            case Constants.STRAWBERRY -> Constants.PATH_TO_STRAWBERRY_PNG;
            default -> throw new RuntimeException();
        };

        return new Image(getClass().getResourceAsStream(path));
    }

}
