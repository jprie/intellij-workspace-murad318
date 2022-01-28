package at.appdevs.basics;

import java.math.BigDecimal;

public class Main {

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

    public static void main(String[] args) {

        Game game = new Game();


        // game.test();

//        game.startGame();

        game.checkForDiagonallyConnectedStonesTopRightBottomLeft();


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
