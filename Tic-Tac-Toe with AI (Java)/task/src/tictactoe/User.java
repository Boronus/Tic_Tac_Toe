package tictactoe;

import java.util.Scanner;

public class User extends Player {
    public final PlayerType type = PlayerType.USER;

    @Override
    public void play(Matrix matrix) {
        Scanner scanner = new Scanner(System.in);

        boolean isCorrect = false;

        while (!isCorrect) {
            System.out.print("Enter the coordinates: > ");

            String inputString = scanner.nextLine();
            String[] splited = inputString.split("\\s+");

            if (splited.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }

            int coordX;
            int coordY;

            try {
                coordX = Integer.parseInt(splited[0]);
                coordY = Integer.parseInt(splited[1]);
            } catch (NumberFormatException nfe) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (coordX < 1 || coordX > 3 || coordY < 1 || coordY > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (matrix.matrix[coordX - 1][coordY - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            matrix.matrix[coordX - 1][coordY - 1] = Player.getFigure(matrix);
            isCorrect = true;
        }
    }
}
