package at.appdevs.basics.extra;

import at.appdevs.basics.app.Board;
import at.appdevs.basics.app.Player;
import at.appdevs.basics.app.Stone;

public class OptimizedWinChecker {

    private Board board;
    private Player currentPlayer;

    public OptimizedWinChecker(Board board, Player currentPlayer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
    }

    // Optimierte Variante, sodass immer nur die Zeile, Spalte, Diagonale/n
    // getestet werden, wo der letzte Stein eingeworfen wurde.
    private boolean checkStoneWinsAt(int row, int col) {

        boolean playerWins;

        playerWins = checkForHorizontallyConnectedStones(row, col);
        playerWins |= checkForVerticallyConnectedStones(row, col);
        playerWins |= checkForDiagonallyConnectedStonesTopLeftBottomRight(row, col);
        playerWins |= checkForDiagonallyConnectedStonesTopRightBottomLeft(row, col);

        return playerWins;
    }

    private boolean checkForHorizontallyConnectedStones(int row, int col) {

        int colIndex = col-3;
        int countStones = 0;
        for (; colIndex < Board.BOARD_WIDTH; colIndex++) {
            if (colIndex < 0) continue;
            Stone stone = board.getStoneAtPosition(row, colIndex);
            if (stone != null && stone.getColor() == currentPlayer.getColor()) {
                countStones++;
                if (countStones == 4) {
                    return true;
                }
            } else {
                countStones = 0;
            }
        }

        return false;
    }

    private boolean checkForVerticallyConnectedStones(int row, int col) {

        int rowIndex = row-3;
        int countStones = 0;
        for (; rowIndex < Board.BOARD_HEIGHT; rowIndex++) {
            if (rowIndex < 0) continue;
            Stone stone = board.getStoneAtPosition(rowIndex, col);
            if (stone != null && stone.getColor() == currentPlayer.getColor()) {
                countStones++;
                if (countStones == 4) {
                    return true;
                }
            } else {
                countStones = 0;
            }
        }

        return false;
    }

    private boolean checkForDiagonallyConnectedStonesTopRightBottomLeft(int row, int col) {

        int rowIndex = row - 3;
        int colIndex = col + 3;
        int countStones = 0;
        int i = 0;
        while (i < Board.BOARD_HEIGHT) {


            if (rowIndex >= 0 && rowIndex < Board.BOARD_HEIGHT && colIndex >= 0 && colIndex < Board.BOARD_WIDTH) {
                i++;
                System.out.println("[" + rowIndex + ", " + colIndex + "]");
                Stone stone = board.getStoneAtPosition(rowIndex, colIndex);
                if (stone != null && stone.getColor() == currentPlayer.getColor()) {
                    countStones++;
                    if (countStones == 4) {
                        return true;
                    }
                } else {
                    countStones = 0;
                }
            }
            rowIndex++;
            colIndex--;

        }
        return false;
    }

    private boolean checkForDiagonallyConnectedStonesTopLeftBottomRight(int row, int col) {

        int rowIndex = row - 3;
        int colIndex = col - 3;
        int countStones = 0;

        for (int i=0; i<Board.BOARD_HEIGHT; ) {
            if (rowIndex >= 0 && rowIndex < Board.BOARD_HEIGHT && colIndex >= 0 && colIndex < Board.BOARD_WIDTH) {
                i++;
                System.out.println("[" + rowIndex + ", " + colIndex + "]");
                Stone stone = board.getStoneAtPosition(rowIndex, colIndex);
                if (stone != null && stone.getColor() == currentPlayer.getColor()) {
                    countStones++;
                    if (countStones == 4) {
                        return true;
                    }
                } else {
                    countStones = 0;
                }
            }
            rowIndex++;
            colIndex++;
        }

        return false;
    }
}
