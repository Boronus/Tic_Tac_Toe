package tictactoe;

public class Matrix {
    public char[][] table = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
    };

    public void showCurrentMatrix() {
        System.out.println("---------");

        for(int i=0; i<3; i++) {
            System.out.print("| ");

            for(int j=0; j<3; j++) {
                System.out.print(table[i][j] + " ");
            }

            System.out.println("|");
        }

        System.out.println("---------");
    }

    public boolean setFigure(int[][] positions, char figure) {
        for (int[] position : positions) {
            if (table[position[0]][position[1]] == ' ') {
                table[position[0]][position[1]] = figure;
                return true;
            }
        }

        return false;
    }

    public int getNumberOfX() {
        int numberOfX = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (table[i][j] == 'X') {
                    numberOfX++;
                }
            }
        }

        return numberOfX;
    }

    public int getNumberOfO() {
        int numberOfO = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (table[i][j] == 'O') {
                    numberOfO++;
                }
            }
        }

        return numberOfO;
    }
}
