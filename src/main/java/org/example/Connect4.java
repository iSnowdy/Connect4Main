package org.example;

public class Connect4 {

    int[][] table;
    int currentPlayer;
    boolean exit;

    public Connect4() {

        table = new int[6][7];
        currentPlayer = 1;
        exit = false;

    }

    public String play(int column) {

        // We check for conditions

        if (exit) {
            return "Game has finished!";
        }

        if (column < 0 || column > 6) {
            return "Invalid column number. Please input a column number between 0 and 6";
        }

        if (isColumnFull(column)) {
            return "Column full!";
        }

        putDownDisc(column);
        if (winningCondition()) {
            exit = true;
            return "Player " + currentPlayer + " wins!";
        }

        if (currentPlayer == 1) {
            currentPlayer = 2;
            return "Player " + 1 + " has a turn";
        }

        else {
            currentPlayer = 1;
            return "Player " + 2 + " has a turn";
        }

    }

    public boolean isColumnFull (int column) {

        return table[0][column] != 0; // If not 0 then its filled

    }

    // Place disks

    public void putDownDisc (int column) {

        for (int row = 5; row >= 0; row --) { // Start from the bottom
            if (table[row][column] == 0) {
                table[row][column] = currentPlayer;

                break;
            }
        }
    }

    // Winning conditions

    public boolean checkHorizontal () {

        for (int row = 0; row < 6; row ++) {
            for (int col = 0; col < 4; col ++) {
                if (table[row][col] == currentPlayer && // Out of index control: col size - 3
                        table[row][col + 1] == currentPlayer &&
                        table[row][col + 2] == currentPlayer &&
                        table[row][col + 3] == currentPlayer) {

                    return exit = true; // End game
                }
            }
        }
        return exit = false; // Continue game
    }


    public boolean checkVertical () {

        for (int row = 0; row < 3; row ++) {
            for (int col = 0; col < 7; col ++) {
                if (table[row][col] == currentPlayer &&
                        table[row + 1][col] == currentPlayer &&
                        table[row + 2][col] == currentPlayer &&
                        table[row + 3][col] == currentPlayer) {

                    return exit = true;
                }
            }
        }
        return exit = false;
    }


    public boolean checkDiagonal () {

        for (int row = 0; row < 3; row ++) {
            for (int col = 0; col < 4; col ++) {
                if (table[row][col] == currentPlayer &&
                        table[row + 1][col + 1] == currentPlayer &&
                        table[row + 2][col + 2] == currentPlayer &&
                        table[row + 3][col + 3] == currentPlayer) {

                    return exit = true;
                }
            }
        }

        for (int row = 0; row < 3; row ++) {
            for (int col = 3; col < 7; col ++) { // Start col 3 because it is reversed
                if (table[row][col] == currentPlayer &&
                        table[row + 1][col - 1] == currentPlayer &&
                        table[row + 2][col - 2] == currentPlayer &&
                        table[row + 3][col - 3] == currentPlayer) {

                    return exit = true;
                }
            }
        }

        return exit = false;

    }

    // Hola

    public boolean winningCondition () {

        return (checkHorizontal() || checkVertical() || checkDiagonal());
    }
}
