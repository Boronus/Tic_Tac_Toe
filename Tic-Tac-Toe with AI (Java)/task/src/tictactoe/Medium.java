package tictactoe;

import java.util.Random;

public class Medium extends Player{
    public final PlayerType type = PlayerType.MEDIUM;

    @Override
    public void play(Matrix matrix) {
        System.out.println("Making move level \"medium\"");
        Random random = new Random();
        boolean success = false;

        while (!success) {
            if (this.checkWinMove(matrix)) {
                break;
            }

            if (this.checkLoseMove(matrix)) {
                break;
            }

            int randomX = random.nextInt(3);
            int randomY = random.nextInt(3);

            if (matrix.matrix[randomX][randomY] == ' ') {
                matrix.matrix[randomX][randomY] = Player.getFigure(matrix);
                success = true;
            }
        }
    }

    public boolean checkWinMove(Matrix matrix) {
        final char figure = Player.getFigure(matrix);

        for (int i=0; i<3; i++) {
            int numberOfFigures = 0;

            for (int j = 0; j < 3; j++) {
                if (matrix.matrix[i][j] == figure) {
                    numberOfFigures++;
                }
            }

            if (numberOfFigures == 2) {
                int[][] positions = {{i,0},{i,1},{i,2}};
                if (matrix.setToEmpty(positions, figure)) {
                    return true;
                }
            }
        }

        for (int i=0; i<3; i++) {
            int numberOfFigures = 0;

            for (int j = 0; j < 3; j++) {
                if (matrix.matrix[j][i] == figure) {
                    numberOfFigures++;
                }
            }

            if (numberOfFigures == 2) {
                int[][] positions = {{0,i},{1,i},{2,i}};
                if (matrix.setToEmpty(positions, figure)) {
                    return true;
                }
            }
        }

        int diagonal1 = 0;

        for (int i=0; i<3; i++) {
            if (matrix.matrix[i][i] == figure) {
                diagonal1++;
            }
        }

        if (diagonal1 == 2) {
            int[][] positions = {{0,0},{1,1},{2,2}};
            if (matrix.setToEmpty(positions, figure)) {
                return true;
            }
        }

        int diagonal2 = 0;

        for (int i=0; i<3; i++) {
            if (matrix.matrix[2-i][i] == figure) {
                diagonal2++;
            }
        }

        if (diagonal2 == 2) {
            int[][] positions = {{2,0},{1,1},{0,2}};
            if (matrix.setToEmpty(positions, figure)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkLoseMove(Matrix matrix) {
        final char figure = Player.getFigure(matrix);
        final char oponentFigure = figure == 'X' ? 'O' : 'X';

        for (int i=0; i<3; i++) {
            int numberOfFigures = 0;

            for (int j = 0; j < 3; j++) {
                if (matrix.matrix[i][j] == oponentFigure) {
                    numberOfFigures++;
                }
            }

            if (numberOfFigures == 2) {
                int[][] positions = {{i,0},{i,1},{i,2}};
                if (matrix.setToEmpty(positions, figure)) {
                    return true;
                }
            }
        }

        for (int i=0; i<3; i++) {
            int numberOfFigures = 0;

            for (int j = 0; j < 3; j++) {
                if (matrix.matrix[j][i] == oponentFigure) {
                    numberOfFigures++;
                }
            }

            if (numberOfFigures == 2) {
                int[][] positions = {{0,i},{1,i},{2,i}};
                if (matrix.setToEmpty(positions, figure)) {
                    return true;
                }
            }
        }

        int diagonal1 = 0;

        for (int i=0; i<3; i++) {
            if (matrix.matrix[i][i] == oponentFigure) {
                diagonal1++;
            }
        }

        if (diagonal1 == 2) {
            int[][] positions = {{0,0},{1,1},{2,2}};
            if (matrix.setToEmpty(positions, figure)) {
                return true;
            }
        }

        int diagonal2 = 0;

        for (int i=0; i<3; i++) {
            if (matrix.matrix[2-i][i] == oponentFigure) {
                diagonal2++;
            }
        }

        if (diagonal2 == 2) {
            int[][] positions = {{2,0},{1,1},{0,2}};

            if (matrix.setToEmpty(positions, figure)) {
                return true;
            }
        }

        return false;
    }
}
