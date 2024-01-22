package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isFinished = false;

        while (!isFinished) {
            System.out.print("Input command: > ");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            String[] splited = inputString.split("\\s+");

            if (splited[0].equals("exit")) {
                isFinished = true;
                continue;
            }

            if (!splited[0].equals("start") || splited.length != 3) {
                System.out.println("Bad parameters!");
                continue;
            }

            Player player1 = Player.getPlayer(splited[1]);
            Player player2 = Player.getPlayer(splited[2]);

            new Game(player1, player2);
        }
    }
}

