package at.appdevs.basics.test;

import at.appdevs.basics.app.Board;
import at.appdevs.basics.app.Color;
import at.appdevs.basics.app.Game;
import at.appdevs.basics.app.Stone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    public static int[][] DIAGONAL_TOP_LEFT_BOTTOM_RIGHT = {
            {0, 0, 0, 0, 0, 0, 0},
            {0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0},
            {0,2,1,0,0,0,0},
            {2,2,1,1,0,0,0},
            {1,2,1,2,1,0,0}
    };

    public static int[][] DIAGONAL_TOP_RIGHT_BOTTOM_LEFT = {
            {0, 0, 0, 0, 0, 0, 0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0},
            {0,2,0,0,1,1,0},
            {2,2,1,1,2,2,0},
            {1,2,1,2,1,2,0}
    };

    public static int[][] HORIZONTAL_LEFT_TO_RIGHT = {
            {0, 0, 0, 0, 0, 0, 0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0},
            {1,2,1,1,1,1,0}
    };

    public static int[][] VERTICAL_TOP_TO_BOTTOM = {
            {0, 0, 0, 0, 0, 0, 0},
            {0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0},
            {0,0,0,0,1,0,0},
            {0,0,0,0,1,0,0},
            {1,2,1,2,1,1,0}
    };

    Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @Test
    void playerRedWinsStonesConnectedHorizontally() {

        Board board = createTestBoard(HORIZONTAL_LEFT_TO_RIGHT);
        game.setBoard(board);
        assertTrue(game.testForWinner(Color.RED));
    }

    @Test
    void playerRedWinsStonesConnectedVertically() {

        Board board = createTestBoard(VERTICAL_TOP_TO_BOTTOM);
        game.setBoard(board);
        assertTrue(game.testForWinner(Color.RED));
    }

    @Test
    void playerRedWinsStonesConnectedDiagonallyTLBR() {

        Board board = createTestBoard(DIAGONAL_TOP_LEFT_BOTTOM_RIGHT);
        game.setBoard(board);
        assertTrue(game.testForWinner(Color.RED));
    }

    @Test
    void playerRedWinsStonesConnectedDiagonallyTRBL() {

        Board board = createTestBoard(DIAGONAL_TOP_RIGHT_BOTTOM_LEFT);
        game.setBoard(board);
        assertTrue(game.testForWinner(Color.RED));
    }

    public static Board createTestBoard(int[][] testArray) {

        Board board = new Board();

        for (int row=0; row<Board.BOARD_HEIGHT; row++) {
            for (int col=0; col<Board.BOARD_WIDTH; col++) {
                if (testArray[row][col] != 0) {
                    board.setStoneAtPosition(row, col, stoneFromInt(testArray[row][col]));
                }

            }
        }

        System.err.println("Testing:");
        System.err.println(board);

        return board;
    }

    private static Stone stoneFromInt(int i) {

        return new Stone(i==1 ? Color.RED : Color.YELLOW);
    }
}