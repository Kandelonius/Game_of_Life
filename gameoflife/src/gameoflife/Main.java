package gameoflife;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        // Output a random square or NxN
        int N = stdIn.nextInt(); // grid dimensions
        int S = stdIn.nextInt(); // seed for RNG
        // declare the multidimensional array
        char[][] grid = new char[N][N];
        createGrid(N,
            S, grid);
//        printGrid(grid);

    }

    public static void createGrid(
        int N,
        int S,
        char[][] grid) {
        // declare and seed rng
        Random rng = new Random(S);
        // string to load in the characters
        boolean check = true;
        char unit = 'a';
        //          loop to fill the array
        for (int i = 0; i < N; i++) {
            check = rng.nextBoolean();
            unit = getChar(check);
            grid[i][i] = unit;
            for (int j = 0; j < N; j++) {
                check = rng.nextBoolean();
                unit = getChar(check);
                grid[i][j] = unit;
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static char getChar(boolean b) {
        if (b) {
            return 'O';
        } else {
            return ' ';
        }
    }

//    public static void printGrid(char[][] grid) {
//        for (int i = )
//    }
}