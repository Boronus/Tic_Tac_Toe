package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    char[][] matrix = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
    };

    public void showCurrentMatrix() {
        System.out.println("---------");

        for(int i=0; i<3; i++) {
            System.out.print("| ");

            for(int j=0; j<3; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println("|");
        }

        System.out.println("---------");
    }

    public void fillMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the cells: > ");
        String initialStateString = scanner.next();

        int symbolIndex = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                matrix[i][j] = initialStateString.charAt(symbolIndex);
                symbolIndex++;
            }
        }
    }

    public boolean setToEmpty(int[][] positions, char figure) {
        for (int i = 0; i < positions.length; i++) {
            if (matrix[positions[i][0]][positions[i][1]] == ' ') {
                matrix[positions[i][0]][positions[i][1]] = figure;
                return true;
            }
        }

        return false;
    }

    public int getNumberOfX() {
        int numberOfX = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (matrix[i][j] == 'X') {
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
                if (matrix[i][j] == 'O') {
                    numberOfO++;
                }
            }
        }

        return numberOfO;
    }
}
