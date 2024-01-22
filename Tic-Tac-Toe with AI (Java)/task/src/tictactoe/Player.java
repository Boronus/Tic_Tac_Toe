package tictactoe;

public class Player {
    public static Player getPlayer(String inputString) {
        return switch (inputString) {
            case "user" -> new User();
            case "easy" -> new Easy();
            case "medium" -> new Medium();
            case "hard" -> new Hard();
            default -> null;
        };

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
