package gameoflife;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        // Output a random square or NxN
        int N = stdIn.nextInt(); // genOne dimensions
        int S = stdIn.nextInt(); // seed for RNG
        // declare the multidimensional array
        char[][] genOne = new char[N][N];
        char[][] genTwo = new char[N][N];
        Universe.createGrid(N,
            S, genOne);
    }
}