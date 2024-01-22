import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tictactoe.Easy;
import tictactoe.Matrix;

public class EasyTest {
    @Test
    public void shouldSetRandomPoint() {
        Easy easy = new Easy();
        Matrix matrix = new Matrix();

        Assertions.assertEquals(matrix.getNumberOfX(), 0);
        easy.play(matrix);
        Assertions.assertEquals(matrix.getNumberOfX(), 1);
    }
}
