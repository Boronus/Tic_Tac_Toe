package tictactoe;

public class Hard extends Player{
    public char currentPlayerFigure = ' ';
    public char opponentPlayerFigure = ' ';

    @Override
    public void play(Matrix matrix) {
        System.out.println("Making move level \"hard\"");

        this.currentPlayerFigure = Player.getFigure(matrix);
        this.opponentPlayerFigure = Player.getOpponentFigure(matrix);

        this.calculateBestMove(matrix);
    }

    public void calculateBestMove(Matrix matrix) {
        int bestScore = -100;
        int bestX = 0;
        int bestY = 0;

        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix.table[i][j] == ' ') {
                    int score = getScoreForTheSquare(matrix, i, j, 0, false);

                    if (score > bestScore) {
                        bestScore = score;
                        bestX = i;
                        bestY = j;
                    }
                }
            }
        }

        matrix.table[bestX][bestY] = this.currentPlayerFigure;
    }

    public int getScore(State state) {
        if (this.currentPlayerFigure == 'X' && state ==State.X_WINS || this.currentPlayerFigure == 'O' && state ==State.O_WINS) {
            return 10;
        }

        if (this.currentPlayerFigure == 'O' && state ==State.X_WINS || this.currentPlayerFigure == 'X' && state ==State.O_WINS) {
            return -10;
        }

        return 0;
    }

    public int getScoreForTheSquare(Matrix matrix, int raw, int column, int depth, boolean isMaximizing) {
        matrix.table[raw][column] = isMaximizing ? this.opponentPlayerFigure : this.currentPlayerFigure;
        int score = calculateMiniMax(matrix, depth +1, isMaximizing);
        matrix.table[raw][column] = ' ';
        return score;
    }

    public int calculateMiniMax(Matrix matrix, int depth, boolean isMaximizing) {
        State result = StateHandler.getState(matrix.table);

        if (result != State.NOT_FINISHED) {
            return getScore(result);
        }

        if (isMaximizing) {
            int bestScore = -10000;

            for (int i=0; i<3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix.table[i][j] == ' ') {
                        int score = getScoreForTheSquare(matrix, i, j, depth, false);

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
                    if (matrix.table[i][j] == ' ') {
                        int score = getScoreForTheSquare(matrix, i, j, depth, true);

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
