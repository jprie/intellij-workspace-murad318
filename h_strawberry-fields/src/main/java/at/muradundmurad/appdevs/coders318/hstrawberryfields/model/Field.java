package at.muradundmurad.appdevs.coders318.hstrawberryfields.model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Field {

    private static final Logger log = LoggerFactory.getLogger(Field.class);

    public static final int NUMBER_ROWS = 7;
    public static final int NUMBER_COLS = 8;


    static List<Square> initSquares = List.of(new Square("p"),
            new Square("P"),
            new Square(""),
            new Square("s"));

    private ObservableList<Square> squares = FXCollections.observableArrayList(new Callback<Square, Observable[]>() {
        @Override
        public Observable[] call(Square param) {
            log.info("Callback called: {}", param.getItem() );
            return new Observable[] {param.itemProperty()};
        }
    });

    public Field() {

//        squares.addAll(initSquares);
        initSquares();
    }

    private void initSquares() {

        for (int rowIndex=0; rowIndex<NUMBER_ROWS; rowIndex++) {

            for (int colIndex=0; colIndex<NUMBER_COLS; colIndex++) {

                squares.add(new Square(""));
            }
        }
    }

    public ObservableList<Square> getSquares() {
        return squares;
    }

}
