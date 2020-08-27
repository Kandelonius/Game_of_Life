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
        universe.setliving(0,1);
        universe.setliving(0,2);
        universe.setliving(0,3);
        universe.printUniverse();
        System.out.println(universe.sumOfNeighbors(1, 2));
    }
}