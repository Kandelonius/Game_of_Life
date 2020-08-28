package gameoflife;

import java.util.Random;
import java.util.Scanner;

public class Intelilife {public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    // Output a random square or NxN
    int N = stdIn.nextInt(); // genOne dimensions
    long S = stdIn.nextLong(); // seed for RNG
    int generations = stdIn.nextInt(); // number of generations
    // declare the multidimensional array
    char[][] gridA = new char[N][N];
    char[][] gridB = new char[N][N];
    createGrid(N,
        S, gridA);
    //        printGrid(grid);

}

    public static void createGrid(
        int N,
        long S,
        char[][] grid) {
        // declare and seed rng
        Random rng = new Random(S);

        // string to load in the characters
        boolean check = true;
        char unit = 'a';
        //          loop to fill the array
        for (int i = 0; i < N; i++) {
            // check = rng.nextBoolean();
            // unit = getChar(check);
            // grid[i][j] = unit;
            for (int j = 0; j < N; j++) {
                check = rng.nextBoolean();
                unit = getChar(check);
                grid[i][j] = unit;
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public void nextGen(int N) {
        int[][] newGen = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = sumOfNeighbors(i,
                    j);
                if (count == 3) {
                    gridB[i][j] = 1;
                } else if (count == 2 && this.state[i][j] == 1) {
                    newGen[i][j] = 1;
                } else {
                    newGen[i][j] = 0;
                }
            }
        }
        gridA = newGen;
    }

    public int sumOfNeighbors(
        int row,
        int column) {
        int count = 0;
        int left = column - 1;
        int top = row - 1;
        int right = column + 1;
        int bot = row + 1;
        // if we are at the top of the field, top will be the bottom
        if (row == 0) {
            top = N - 1;
        }
        // if we are at the bottom of the field, bot will be at the top
        if (row == N - 1) {
            bot = 0;
        }
        // if we are at the left of the field, left will be the right border~
        if (column == 0) {
            left = N - 1;
        }
        // if we are at the right of the field, right will be the left border
        if (column == N - 1) {
            right = 0;
        }
        count += this.state[top][left];
        count += this.state[top][column];
        count += this.state[top][right];

        count += this.state[row][left];
        count += this.state[row][right];

        count += this.state[bot][left];
        count += this.state[bot][column];
        count += this.state[bot][right];
        return count;
    }

    public static char getChar(boolean b) {
        if (b) {
            return 'O';
        } else {
            return ' ';
        }
    }
}
