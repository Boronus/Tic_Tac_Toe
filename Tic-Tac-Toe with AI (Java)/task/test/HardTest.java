import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tictactoe.Hard;
import tictactoe.Matrix;

public class HardTest {
    @Test
    public void shouldSetPoint() {
        Hard medium = new Hard();
        Matrix matrix = new Matrix();

        Assertions.assertEquals(matrix.getNumberOfX(), 0);
        medium.play(matrix);
        Assertions.assertEquals(matrix.getNumberOfX(), 1);
    }

    @Test
    public void shouldDoTheBestMove() {
        Hard medium = new Hard();
        Matrix matrix = new Matrix();
        matrix.table = new char[][]{
                {'X', ' ', 'O'},
                {'O', ' ', ' '},
                {'X', ' ', ' '},
        };

        char[][] expected = new char[][]{
                {'X', ' ', 'O'},
                {'O', ' ', ' '},
                {'X', ' ', 'X'},
        };

        medium.play(matrix);
        Assertions.assertArrayEquals(matrix.table, expected);
    }
}
