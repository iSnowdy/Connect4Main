package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Connect4 { // Main
    private int[][] table;
    int currentPlayer; // 1 or 2
    boolean exit; // state of the game

    public Connect4() {

        table = new int[6][7];
        currentPlayer = 1;
        exit = false;

        // System.out.println(Arrays.deepToString(table));

    }


    public String Play(int column) {

        // We check for the rules of the game

        if (exit) {
            return "Game has finished!";
        }

        if (column < 0 || column > 6) {
            return "Invalid column! Column number should be between 0 and 6.";
        }

        if (isColumnFull(column)) {
            return "Column full!";
        }

        putDownDisc(column);
        if (isWinningMove()) {
            drawTable();
            exit = true;
            congratulateWinner();
            return "Player " + currentPlayer + " wins!";
        }

        currentPlayer = currentPlayer == 1 ? 2 : 1; // If it is Player 1 then give the turn to Player 2
        return "Player " + currentPlayer + " has a turn";
    }

    private boolean isColumnFull(int column) {
        return table[0][column] != 0; // Table is full of 0's when created
    }

    private void putDownDisc(int column) {
        for (int row = 5; row >= 0; row--) { // We start from the bottom
            if (table[row][column] == 0) {
                table[row][column] = currentPlayer;

                // System.out.println(Arrays.deepToString(table));

                break; // :)))
            }
        }
    }

    // Now we check for the 3 winning conditions
    // Columns = horizontals. Rows = verticals. Diagonals??

    private boolean checkHorizontal() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (    table[row][col] == currentPlayer &&
                        table[row][col + 1] == currentPlayer &&
                        table[row][col + 2] == currentPlayer &&
                        table[row][col + 3] == currentPlayer) {

                    // System.out.println(Arrays.deepToString(table));
                    return exit = true;
                }
            }
        }
        return exit = false;
    }

    private boolean checkVertical() {
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row < 3; row++) {
                if (    table[row][col] == currentPlayer &&
                        table[row + 1][col] == currentPlayer &&
                        table[row + 2][col] == currentPlayer &&
                        table[row + 3][col] == currentPlayer) {

                    // System.out.println(Arrays.deepToString(table));
                    return exit = true;
                }
            }
        }
        return exit = false;
    }

    private boolean checkDiagonal() {
        for (int row = 0; row < 3; row++) { // Bottom left ---> Top right
            for (int col = 0; col < 4; col++) {
                if (    table[row][col] == currentPlayer &&
                        table[row + 1][col + 1] == currentPlayer &&
                        table[row + 2][col + 2] == currentPlayer &&
                        table[row + 3][col + 3] == currentPlayer) {

                    // System.out.println(Arrays.deepToString(table));
                    return exit = true;
                }
            }
        }
        for (int row = 0; row < 3; row++) { // Bottom right --> Top left
            for (int col = 3; col < 7; col++) {
                if (    table[row][col] == currentPlayer &&
                        table[row + 1][col - 1] == currentPlayer &&
                        table[row + 2][col - 2] == currentPlayer &&
                        table[row + 3][col - 3] == currentPlayer) {

                    // System.out.println(Arrays.deepToString(table));
                    return exit = true;
                }
            }
        }
        return exit = false;
    }

    private boolean isWinningMove() {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }


    public void drawTable() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print("| ");
                switch (table[row][col]) { // Takes the value of that position
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("X");
                        break;
                    case 2:
                        System.out.print("O");
                        break;
                }
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
        System.out.println("  0   1   2   3   4   5   6");
    }

    private void congratulateWinner() {
        System.out.println("Congratulations Player " + currentPlayer + "!");
        if (currentPlayer == 1) {
            System.out.println("   _____          __  __ ______    ______      ________ _____  ");
            System.out.println("  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ ");
            System.out.println(" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |");
            System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / ");
            System.out.println(" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ ");
            System.out.println("  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
        } else {
            System.out.println("   _____          __  __ ______    ______      ________ _____  ");
            System.out.println("  / ____|   /\\   |  \\/  |  ____|  / __ \\ \\    / /  ____|  __ \\ ");
            System.out.println(" | |  __   /  \\  | \\  / | |__    | |  | \\ \\  / /| |__  | |__) |");
            System.out.println(" | | |_ | / /\\ \\ | |\\/| |  __|   | |  | |\\ \\/ / |  __| |  _  / ");
            System.out.println(" | |__| |/ ____ \\| |  | | |____  | |__| | \\  /  | |____| | \\ \\ ");
            System.out.println("  \\_____/_/    \\_\\_|  |_|______|  \\____/   \\/   |______|_|  \\_\\");
        }
    }

    public static void main(String[] args) {

        Connect4 game = new Connect4();

        Scanner scanner = new Scanner(System.in);

        while (!game.exit) {
            game.drawTable();
            System.out.println(game.Play(scanner.nextInt()));
        }
    }
}
