import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tictactoe.Matrix;
import tictactoe.Medium;

public class MediumTest {
    @Test
    public void shouldSetPoint() {
        Medium medium = new Medium();
        Matrix matrix = new Matrix();

        Assertions.assertEquals(matrix.getNumberOfX(), 0);
        medium.play(matrix);
        Assertions.assertEquals(matrix.getNumberOfX(), 1);
    }

    @Test
    public void shouldSetPointToWinHorizontally() {
        Medium medium = new Medium();
        Matrix matrix = new Matrix();
        matrix.table = new char[][]{
                {'X', 'X', ' '},
                {'O', ' ', ' '},
                {' ', 'O', ' '},
        };

        char[][] expected = new char[][]{
                {'X', 'X', 'X'},
                {'O', ' ', ' '},
                {' ', 'O', ' '},
        };

        medium.play(matrix);
        Assertions.assertArrayEquals(matrix.table, expected);
    }

    @Test
    public void shouldSetPointToWinVertically() {
        Medium medium = new Medium();
        Matrix matrix = new Matrix();
        matrix.table = new char[][]{
                {'X', ' ', ' '},
                {'X', 'O', ' '},
                {' ', 'O', ' '},
        };

        char[][] expected = new char[][]{
                {'X', ' ', ' '},
                {'X', 'O', ' '},
                {'X', 'O', ' '},
        };

        medium.play(matrix);
        Assertions.assertArrayEquals(matrix.table, expected);
    }

    @Test
    public void shouldSetPointToWinDiagonally() {
        Medium medium = new Medium();
        Matrix matrix = new Matrix();
        matrix.table = new char[][]{
                {'X', ' ', ' '},
                {'O', 'X', ' '},
                {' ', 'O', ' '},
        };

        char[][] expected = new char[][]{
                {'X', ' ', ' '},
                {'O', 'X', ' '},
                {' ', 'O', 'X'},
        };

        medium.play(matrix);
        Assertions.assertArrayEquals(matrix.table, expected);
    }

    @Test
    public void shouldSetPointNotToLoseHorizontally() {
        Medium medium = new Medium();
        Matrix matrix = new Matrix();
        matrix.table = new char[][]{
                {'X', ' ', ' '},
                {'O', 'O', ' '},
                {'X', ' ', ' '},
        };

        char[][] expected = new char[][]{
                {'X', ' ', ' '},
                {'O', 'O', 'X'},
                {'X', ' ', ' '},
        };

        medium.play(matrix);
        Assertions.assertArrayEquals(matrix.table, expected);
    }

    @Test
    public void shouldSetPointNotToLoseVertically() {
        Medium medium = new Medium();
        Matrix matrix = new Matrix();
        matrix.table = new char[][]{
                {'X', ' ', ' '},
                {' ', 'O', ' '},
                {' ', 'O', 'X'},
        };

        char[][] expected = new char[][]{
                {'X', 'X', ' '},
                {' ', 'O', ' '},
                {' ', 'O', 'X'},
        };

        medium.play(matrix);
        Assertions.assertArrayEquals(matrix.table, expected);
    }

    @Test
    public void shouldSetPointNotToLoseDiagonally() {
        Medium medium = new Medium();
        Matrix matrix = new Matrix();
        matrix.table = new char[][]{
                {'O', ' ', ' '},
                {'X', 'O', ' '},
                {' ', 'X', ' '},
        };

        char[][] expected = new char[][]{
                {'O', ' ', ' '},
                {'X', 'O', ' '},
                {' ', 'X', 'X'},
        };

        medium.play(matrix);
        Assertions.assertArrayEquals(matrix.table, expected);
    }
}
