import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tictactoe.Matrix;
import tictactoe.Player;

public class PlayerTest {
    @Test
    public void shouldGetPlayerByInputString() {
        Player user = Player.getPlayer("user");
        Player easy = Player.getPlayer("easy");
        Player medium = Player.getPlayer("medium");
        Player hard = Player.getPlayer("hard");
        Player defaultPlayer = Player.getPlayer("some text");

        Assertions.assertEquals(user.getClass().getSimpleName(), "User");
        Assertions.assertEquals(easy.getClass().getSimpleName(), "Easy");
        Assertions.assertEquals(medium.getClass().getSimpleName(), "Medium");
        Assertions.assertEquals(hard.getClass().getSimpleName(), "Hard");
        Assertions.assertNull(defaultPlayer);
    }

    @Test
    public void shouldReturnFigures() {
        Matrix matrix = new Matrix();
        matrix.table = new char[][]{
                {'X', 'X', ' '},
                {'O', ' ', ' '},
                {' ', 'O', ' '},
        };

        Assertions.assertEquals(Player.getFigure(matrix), 'X');
        Assertions.assertEquals(Player.getOpponentFigure(matrix), 'O');
    }
}
