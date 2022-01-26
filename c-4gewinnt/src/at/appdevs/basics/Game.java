package at.appdevs.basics;

import java.util.Scanner;

public class Game {

    public static final Scanner scanner = new Scanner(System.in);
    private Board board = new Board();
    private Player[] players = new Player[2];
    private Player currentPlayer;

    public void createStones() {

        Stone stone = new Stone(Color.RED);
    }

    public void test() {

        // Setze ein Stone auf das Spielfeld setze
        board.setStoneAtPosition(2, 2, new Stone(Color.RED));
        board.setStoneAtPosition(3, 3, new Stone(Color.YELLOW));
        printBoard();

    }

    public void setBoard(Board board) {
        this.board = board;
    }

    // Der Spielablauf
    public void startGame() {



        for (int i=0; i< players.length; i++) {
            // Pro Spieler: gibt Namen ein UND bekommt eine Farbe
            System.out.println("Bitte geben Sie einen Namen für Spieler " + i + " ein!");
            String name = scanner.next();
            Player player = new Player(name, Color.values()[i]);
            players[i] = player;
        }


        // Spielfeld ausgeben
        printBoard();

        // Auswahl, wo möchte aktueller Spieler den Stein einwerfen
        // (Schleife mit End-Bedingung: Spiel beendet)
        // In der Schleife: Entscheidung wer dran ist
        boolean doStop = false;
        int round = 0;
        do {
            currentPlayer = players[round % 2];
            System.out.println("Geben Sie eine Spalte an, wo ihr Stein eingeworfen werden soll");
            int column = scanner.nextInt()-1;
            int row;
            if ((row = throwStoneIntoColumn(column)) == -1) {
                System.out.println("Spalte bereits voll!");
            } else {
                // Stein erfolgreich gelegt
                if (checkStoneWinsAt(row, column)) {
                    System.out.println("Hurray you won!!");
                    doStop = true;
                }
                round++;
            }

            printBoard();

        } while(!doStop);


    }

    private boolean checkCurrentPlayerWins() {

        boolean playerWins;

        playerWins = checkForHorizontallyConnectedStones();
        playerWins |= checkForVerticallyConnectedStones();
        playerWins |= checkForDiagonallyConnectedStonesTopLeftBottomRight();
        playerWins |= checkForDiagonallyConnectedStonesTopRightBottomLeft();
//        playerWins |= checkCurrentPlayerWinsDiagonalFromLeftUp();

        return playerWins;
    }

    private boolean checkStoneWinsAt(int row, int col) {

        boolean playerWins;

        playerWins = checkForHorizontallyConnectedStones(row, col);
        playerWins |= checkForVerticallyConnectedStones(row, col);
        playerWins |= checkForDiagonallyConnectedStonesTopLeftBottomRight(row, col);
        playerWins |= checkForDiagonallyConnectedStonesTopRightBottomLeft(row, col);

        return playerWins;
    }

    private boolean checkForDiagonallyConnectedStonesTopLeftBottomRight() {

        for (int i = 0; i < ((Board.BOARD_WIDTH + Board.BOARD_HEIGHT) - 1); i++) {

            int row = i % Board.BOARD_WIDTH;
            int col = i<Board.BOARD_WIDTH ? i : 0;
            int countStones = 0;
            while (row < Board.BOARD_HEIGHT && col < Board.BOARD_WIDTH) {

                Stone stone = board.getStoneAtPosition(row, col);
                if (stone != null && stone.getColor() == currentPlayer.getColor()) {
                    countStones++;
                    if (countStones == 4) {
                        return true;
                    }
                } else {
                    countStones = 0;
                }

                // go from top-left to bottom-right
                row++;
                col++;
            }
        }

        return false;
    }

    private boolean checkForDiagonallyConnectedStonesTopRightBottomLeft() {

        for (int i = Board.BOARD_WIDTH+Board.BOARD_HEIGHT-1; i>=0; i--) {

            int row = i > Board.BOARD_WIDTH ? i % Board.BOARD_WIDTH : 0;
            int col = i >= Board.BOARD_WIDTH ? Board.BOARD_WIDTH-1 : i;
            int countStones = 0;
            while (row < Board.BOARD_HEIGHT && col >= 0) {

//                System.out.println("[" + row + ", " + col + "]");
                Stone stone = board.getStoneAtPosition(row, col);
                if (stone != null && stone.getColor() == currentPlayer.getColor()) {
                    countStones++;
                    if (countStones == 4) {
                        return true;
                    }
                } else {
                    countStones = 0;
                }

                // go from top-right to bottom-left
                row++;
                col--;
            }
        }

        return false;
    }

//    private boolean checkCurrentPlayerWinsDiagonalFromLeftUp() {
//
//        // überprüfe nur Farbe des currentPlayer
//        for (int i=0; i<Board.BOARD_WIDTH-1; i++) {
//            int col=i+3<Board.BOARD_WIDTH ? i+3 : Board.BOARD_WIDTH-1;
//            int row = i<=Board.BOARD_HEIGHT-2? 0:i-Board.BOARD_HEIGHT+2;
//            int countStones = 0;
//
//            while(row < Board.BOARD_HEIGHT && col>=0){
//                System.out.println("[" + row + ", " + col + "]");
//                Stone stone = board.getStoneAtPosition(row, col);
//                if (stone != null && stone.getColor() == currentPlayer.getColor()) {
//                    countStones++;
//                    if (countStones == 4) {
//                        return true;
//                    }
//                } else {
//                    countStones = 0;
//                }
//                col--;
//                row++;
//            }
//        }
//        return false;
//    }

    private boolean checkForVerticallyConnectedStones() {

        int countStones = 0;

        for (int colIndex=0; colIndex<Board.BOARD_WIDTH; colIndex++) {

            for (int rowIndex=0; rowIndex<Board.BOARD_HEIGHT; rowIndex++) {

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
        }

        return false;
    }

    private boolean checkForHorizontallyConnectedStones() {

        int countStones = 0;
        for (int rowIndex=0; rowIndex<Board.BOARD_HEIGHT; rowIndex++) {

            for (int colIndex=0; colIndex<Board.BOARD_WIDTH; colIndex++) {

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
        }

        return false;
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

    // Gibt true, wenn Stone eingeworfen werden konnte
    // Gibt false, wenn nicht!
    private int throwStoneIntoColumn(int column) {

        int row = Board.BOARD_HEIGHT-1;
        while (row >= 0)  {
            if (board.getStoneAtPosition(row, column) == null) {
                board.setStoneAtPosition(row, column, new Stone(currentPlayer.getColor()));
                return row;
            }
            row--;
        }
        return -1;
    }

    public void printBoard() {

        System.out.println(board);

    }

    public boolean testForWinner(Color color) {
        currentPlayer = new Player("testPlayer", color);
        return checkCurrentPlayerWins();
    }

    public boolean testForWinnerStoneAt(Color color, int row, int col) {
        currentPlayer = new Player("testPlayer", color);
        return checkStoneWinsAt(row, col);
    }
}
