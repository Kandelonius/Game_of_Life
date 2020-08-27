package gameoflife;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        // Output a random square or NxN
        int N = stdIn.nextInt(); // genOne dimensions
        int S = stdIn.nextInt(); // seed for RNG
        // declare the multidimensional array
        //        char[][] genA = new char[N][N];
        //        char[][] genB = new char[N][N];
        Universe universe = new Universe(N, S);
        universe.setliving(1,1);
        universe.setliving(1,2);
        universe.setliving(1,3);
        universe.printUniverse();

    }
}