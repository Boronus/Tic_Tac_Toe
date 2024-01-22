import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tictactoe.Matrix;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MatrixTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void shouldShowTheMatrix() {
        Matrix matrix = new Matrix();
        matrix.showCurrentMatrix();
        Assertions.assertTrue(outContent.toString().contains("---------"));
        Assertions.assertTrue(outContent.toString().contains("|       |"));
    }

    @Test
    public void shouldSetPositionsToEmpty() {
        Matrix matrix = new Matrix();

        matrix.table = new char[][]{
                {' ', 'X', ' '},
                {'O', ' ', ' '},
                {' ', 'O', ' '},
        };

        int[][] positions = {{0,0}};

        matrix.setFigure(positions, 'X');

        char[][] expected = new char[][]{
                {'X', 'X', ' '},
                {'O', ' ', ' '},
                {' ', 'O', ' '},
        };

        Assertions.assertArrayEquals(matrix.table, expected);
    }

    @Test
    public void shouldGetNUmberOfFigures() {
        Matrix matrix = new Matrix();

        matrix.table = new char[][]{
                {' ', 'X', ' '},
                {'O', ' ', ' '},
                {' ', 'O', ' '},
        };

        Assertions.assertEquals(1, matrix.getNumberOfX());
        Assertions.assertEquals(2, matrix.getNumberOfO());

    }
}
