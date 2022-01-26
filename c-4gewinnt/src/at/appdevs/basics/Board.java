package at.appdevs.basics;

import java.util.Arrays;

public class Board {

    public static final int BOARD_WIDTH = 7;
    public static final int BOARD_HEIGHT = 6;

    // Spielfeld
    private Square[][] squares = new Square[BOARD_HEIGHT][BOARD_WIDTH];

    public Board() {
        initSquaresArray();
    }

    public void initSquaresArray() {

        for (int rowIndex =0; rowIndex < BOARD_HEIGHT; rowIndex++) {

            for (int colIndex =0; colIndex < BOARD_WIDTH; colIndex++) {

                squares[rowIndex][colIndex] = new Square();
            }
        }
    }

    public void setStoneAtPosition(int row, int col, Stone stone) {

        // squares[row][col] = stone;
        squares[row][col].setStone(stone);
    }

    @Override
    public String toString() {

        String output = "";
        for (int caption=0; caption <BOARD_WIDTH; caption++) {
            output += (caption + 1) + "\t";
        }
        output += "\n";

        for (int rowIndex=0; rowIndex<BOARD_HEIGHT; rowIndex++) {

            for (int colIndex=0; colIndex<BOARD_WIDTH; colIndex++) {

                // yryr...yr
                output += squares[rowIndex][colIndex].toString() + "\t";
            }

            output += "\n";
        }

        return output;
    }

    public Stone getStoneAtPosition(int row, int column) {

        return squares[row][column].getStone();
    }

}
