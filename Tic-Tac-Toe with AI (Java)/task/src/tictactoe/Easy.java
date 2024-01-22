package tictactoe;

import java.util.Random;

public class Easy extends Player {
    @Override
    public void play(Matrix matrix) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        boolean success = false;

        while (!success) {
            int randomX = random.nextInt(3);
            int randomY = random.nextInt(3);

            if (matrix.table[randomX][randomY] == ' ') {
                matrix.table[randomX][randomY] = Player.getFigure(matrix);
                success = true;
            }
        }
    }
}
