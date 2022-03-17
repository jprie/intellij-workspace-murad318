package at.muradundmurad.appdevs.coders318.i_strawberryfields;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class Field {

    // Rufe 'call' auf, sobald sich die itemProperty eines der Squares in der Liste ändert
    private ObservableList<Square> squares = FXCollections.observableArrayList(new Callback<Square, Observable[]>() {
        @Override
        public Observable[] call(Square param) {
            System.out.println("callback for square");
            return new Observable[] {param.itemProperty()};
        }
    });

    public Field() {

        initSquares();
        initItems();
    }

    private void initItems() {

        squares.get(10).setItem(Constants.PERSON_MALE);
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
}
