package tictactoe;

public class StateHandler {
    public static String getStateMessage(State state) {
        switch (state) {
            case DRAW -> { return "Draw"; }
            case X_WINS -> { return "X wins"; }
            case O_WINS -> { return "O wins"; }
            default -> { return "Game not finished"; }
        }
    }

    public static void printStateMessage(State state) {
        System.out.println(getStateMessage(state));
    }

    public static State getState(char[][] matrix) {
        for (int i=0; i<3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                if(matrix[i][0] == 'X') {
                    return State.X_WINS;
                }

                if(matrix[i][0] == 'O') {
                    return State.O_WINS;
                }
            }

            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) {
                if(matrix[0][i] == 'X') {
                    return State.X_WINS;
                }

                if(matrix[0][i] == 'O') {
                    return State.O_WINS;
                }
            }
        }

        if (
            matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]
            || matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]
        ) {
            if(matrix[1][1] == 'X') {
                return State.X_WINS;
            }

            if(matrix[1][1] == 'O') {
                return State.O_WINS;
            }
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (matrix[i][j] == ' ') {
                    return State.NOT_FINISHED;
                }
            }
        }

        return State.DRAW;
    }
}
