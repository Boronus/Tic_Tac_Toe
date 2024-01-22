import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tictactoe.Matrix;
import tictactoe.User;

import java.io.*;

public class UserTest {
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
    public void shouldSetPoint() {
        System.setIn(new ByteArrayInputStream("1 1".getBytes()));

        User user = new User();
        Matrix matrix = new Matrix();

        Assertions.assertEquals(matrix.getNumberOfX(), 0);
        user.play(matrix);
        Assertions.assertEquals(matrix.getNumberOfX(), 1);
        Assertions.assertEquals(matrix.table[0][0], 'X');
    }

    @Test
    public void shouldPrintAnErrorWhenIncorrectInput() {
        System.setIn(new ByteArrayInputStream("1 11\na d\n1 1".getBytes()));

        User user = new User();
        Matrix matrix = new Matrix();
        user.play(matrix);

        Assertions.assertTrue(outContent.toString().contains("Coordinates should be from 1 to 3!"));
        Assertions.assertTrue(outContent.toString().contains("You should enter numbers!"));
    }
}
