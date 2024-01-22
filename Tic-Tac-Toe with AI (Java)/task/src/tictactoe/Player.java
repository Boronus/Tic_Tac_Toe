package tictactoe;

import java.util.Scanner;

public class Player {
    public PlayerType type;

    public static Player getPlayer(String inputString) {
        if (inputString.equals("user")) {
            return new User();
        }

        if (inputString.equals("easy")) {
            return new Easy();
        }

        if (inputString.equals("medium")) {
            return new Medium();
        }

        if (inputString.equals("hard")) {
            return new Hard();
        }

        return null;
    }

    public void play(Matrix matrix) {}

    public static char getFigure(Matrix matrix) {
        if (matrix.getNumberOfX() == matrix.getNumberOfO()) {
            return 'X';
        } else {
            return 'O';
        }
    }

    public static char getOpponentFigure(Matrix matrix) {
        if (matrix.getNumberOfX() == matrix.getNumberOfO()) {
            return 'O';
        } else {
            return 'X';
        }
    }
}
