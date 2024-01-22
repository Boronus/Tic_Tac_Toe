package tictactoe;

import java.util.Random;

public class Hard extends Player{
    public final PlayerType type = PlayerType.HARD;
    public char currentPlayerFigure = ' ';
    public char oponentPlayerFigure = ' ';

    @Override
    public void play(Matrix matrix) {
        System.out.println("Making move level \"hard\"");

        this.currentPlayerFigure = Player.getFigure(matrix);
        this.oponentPlayerFigure = Player.getOpponentFigure(matrix);

        this.bestMove(matrix);
    }

    public void bestMove(Matrix matrix) {
        int bestScore = -100;
        int bestX = 0;
        int bestY = 0;

        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix.matrix[i][j] == ' ') {
                    matrix.matrix[i][j] = this.currentPlayerFigure;
                    int score = minimax(matrix, 0, false);
                    matrix.matrix[i][j] = ' ';

                    if (score > bestScore) {
                        bestScore = score;
                        bestX = i;
                        bestY = j;
                    }
                }
            }
        }

        matrix.matrix[bestX][bestY] = this.currentPlayerFigure;
    }

    public int getScore(State state, Matrix matrix) {
        if (this.currentPlayerFigure == 'X' && state ==State.X_WINS || this.currentPlayerFigure == 'O' && state ==State.O_WINS) {
            return 10;
        }

        if (this.currentPlayerFigure == 'O' && state ==State.X_WINS || this.currentPlayerFigure == 'X' && state ==State.O_WINS) {
            return -10;
        }

        return 0;
    }

    public int minimax(Matrix matrix, int depth, boolean isMaximizing) {
        State result = StateHandler.getState(matrix.matrix);

        if (result != State.NOT_FINISHED) {
            return getScore(result, matrix);
        }

        if (isMaximizing) {
            int bestScore = -10000;

            for (int i=0; i<3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix.matrix[i][j] == ' ') {
                        matrix.matrix[i][j] = this.currentPlayerFigure;
                        var score = minimax(matrix, depth +1, false);
                        matrix.matrix[i][j] = ' ';

                        if (score > bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }

            return bestScore;
        } else {
            int bestScore = 10000;

            for (int i=0; i<3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix.matrix[i][j] == ' ') {
                        matrix.matrix[i][j] = this.oponentPlayerFigure;
                        var score = minimax(matrix, depth +1, true);
                        matrix.matrix[i][j] = ' ';

                        if (score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }

            return bestScore;
        }
    }
}
