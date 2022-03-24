package at.muradundmurad.appdevs.coders318.i_strawberryfields.model;

import at.muradundmurad.appdevs.coders318.i_strawberryfields.app.Constants;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyCode;
import javafx.util.Callback;

public class Field {

    // Rufe 'call' auf, sobald ein Square eingefügt wird, und überwache dann die Properties im Observable-Array
    private ObservableList<Square> squares = FXCollections.observableArrayList(new Callback<Square, Observable[]>() {
        @Override
        public Observable[] call(Square square) {
            System.out.println("callback for square");
            return new Observable[] {square.itemProperty()};
        }
    });



    public Field() {

        // Erzeugt die 1-dim Liste
        initSquares();


    }



    public void setItemAtPosition(String item, Position position) {

        squares.get(indexFromPosition(position)).setItem(item);
    }

    private void initSquares() {

        for (int i=0; i<(Constants.NUMBER_ROWS*Constants.NUMBER_COLS); i++) {

            System.out.println("initSquares: " + i);
            squares.add(new Square(null));
        }
    }

    public ObservableList<Square> getSquares() {
        return squares;
    }


    /**
     * Überprüfe ob Position auf dem Spielfeld ist
     * @param newPosition
     * @return
     */
    public boolean isValidPosition(Position newPosition) {

        boolean xValid = newPosition.getX() >= 0 && newPosition.getX() < Constants.NUMBER_COLS;
        boolean yValid = newPosition.getY() >= 0 && newPosition.getY() < Constants.NUMBER_ROWS;
        return xValid && yValid;
    }

    public Position moveToPosition(Position currentPosition, Position newPosition) {

        // 1. item in square an currentPosition finden
        int index = indexFromPosition(currentPosition);
        String item = squares.get(index).getItem();

        // 2. item von square löschen (auf null setzen)
        squares.get(index).setItem(null);

        // 3. in square an neuer Position einfügen
        int newIndex = indexFromPosition(newPosition);
        squares.get(newIndex).setItem(item);

        // 4. Position updaten
//        currentPosition = newPosition;
        return newPosition;
    }

    /**
     * Umrechnung von 2D-Koordinaten auf 1D-Listen-Index
     * @param newPosition
     * @return
     */
    private int indexFromPosition(Position newPosition) {
        return newPosition.getX() + newPosition.getY()*Constants.NUMBER_COLS;
    }


}
