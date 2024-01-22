package tictactoe;

public class Game {
    Matrix matrix = new Matrix();
    State state = State.NOT_FINISHED;

    public Game(Player player1, Player player2) {
        matrix.showCurrentMatrix();

        while (state == State.NOT_FINISHED) {
            player1.play(matrix);

            this.updateState();

            if (state != State.NOT_FINISHED) {
                break;
            }

            player2.play(matrix);

            this.updateState();

            if (state != State.NOT_FINISHED) {
                break;
            }
        }

        StateHandler.printStateMessage(state);
    }

    void updateState() {
        matrix.showCurrentMatrix();
        state = StateHandler.getState(matrix.table);
    }
}
