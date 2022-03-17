package at.muradundmurad.appdevs.coders318.hstrawberryfields.model;

import javafx.scene.input.KeyCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {

    private static final Logger log = LoggerFactory.getLogger(Game.class);

    private Field field = new Field();

    private Position startingPosition = new Position(0,0);
    private Position currentPosition = new Position(0,0);
    private Position endPosition = new Position(0,0);

    public Game() {
        initItems();
    }

    public void handleKeyPressed(KeyCode keyCode) {

        log.info("Key with code: {}", keyCode);

        log.info("currentPosition: {}", currentPosition);
        endPosition = switch(keyCode) {
            case UP -> new Position(currentPosition.x, currentPosition.y-1);
            case DOWN -> new Position(currentPosition.x, currentPosition.y+1);
            case LEFT -> new Position(currentPosition.x-1, currentPosition.y);
            case RIGHT -> new Position(currentPosition.x+1, currentPosition.y);
            default -> startingPosition;
        };

        try {
            moveToPosition(currentPosition, endPosition);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initItems() {

        // Person at 0,0
        field.getSquares().get(0).setItem("P");
    }

    public void moveToPosition(Position currentPosition, Position endPosition) throws Exception {


        // current index
        int startIndex = currentPosition.x + currentPosition.y * (Field.NUMBER_COLS);
        int endIndex = endPosition.x + endPosition.y * (Field.NUMBER_COLS);

        log.info("Start: {}, End: {}", startIndex, endIndex);

        if (startIndex >= 0 && startIndex < field.getSquares().size() &&
                endIndex >= 0 && endIndex < field.getSquares().size()) {
            String item = field.getSquares().get(startIndex).getItem();
            field.getSquares().get(startIndex).setItem("");
            field.getSquares().get(endIndex).setItem(item);

            this.currentPosition = endPosition;
            log.info("End position after move: {}", this.currentPosition);
        } else {
            throw new Exception("Move outside field");
        }


    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
