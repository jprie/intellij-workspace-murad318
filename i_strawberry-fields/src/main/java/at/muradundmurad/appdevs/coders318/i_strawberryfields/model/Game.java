package at.muradundmurad.appdevs.coders318.i_strawberryfields.model;

import at.muradundmurad.appdevs.coders318.i_strawberryfields.app.Constants;
import javafx.scene.input.KeyCode;

public class Game {

    private Field field = new Field();
    private Position currentPosition;

    public Game() {
        // Setzt Items an eine Startposition
        initItems();
    }

    public Field getField() {
        return field;
    }

    // TODO: ins Game
    private void initItems() {

        // Current festlegen und die Person_Female dort einfügen
        currentPosition = new Position(0,0);
        field.setItemAtPosition(Constants.PERSON_FEMALE, currentPosition);

        // initStrawberries
        field.setItemAtPosition(Constants.STRAWBERRY, new Position(4,5));
        field.setItemAtPosition(Constants.STRAWBERRY, new Position(4,1));
        field.setItemAtPosition(Constants.STRAWBERRY, new Position(4,3));
        field.setItemAtPosition(Constants.STRAWBERRY, new Position(1,5));
        field.setItemAtPosition(Constants.STRAWBERRY, new Position(3,2));
        field.setItemAtPosition(Constants.STRAWBERRY, new Position(4,5));
        field.setItemAtPosition(Constants.STRAWBERRY, new Position(5,4));
        field.setItemAtPosition(Constants.STRAWBERRY, new Position(4,4));
    }

    // TODO: ins Game
    public void handleKeyPressed(KeyCode code) {

        Position newPosition = switch(code) {
            case UP, W -> createPosition(0, -1);
            case DOWN, S -> createPosition(0, 1);
            case LEFT, A -> createPosition(-1, 0);
            case RIGHT, D -> createPosition(1, 0);
            default -> null;
        };

        if (newPosition != null) {

            if (field.isValidPosition(newPosition)) {
                currentPosition = field.moveToPosition(currentPosition, newPosition);
            } else {
                System.err.println("newPosition is invalid");
            }
        }
    }

    private Position createPosition(int x, int y) {

        return new Position(currentPosition.getX()+x, currentPosition.getY()+y);
    }

}
