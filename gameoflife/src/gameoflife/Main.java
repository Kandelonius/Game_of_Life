package gameoflife;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        // Output a random square or NxN
        int N = stdIn.nextInt(); // genOne dimensions
        long S = stdIn.nextLong(); // seed for RNG
        int generations = stdIn.nextInt(); // number of generations
        // declare the multidimensional array
        //        char[][] genA = new char[N][N];
        //        char[][] genB = new char[N][N];
        Universe universe = new Universe(N, S);
//        universe.setLiving(0,1);
//        universe.setLiving(0,2);
//        universe.setLiving(0,3);
        for (int i = 0; i < generations; i++) {
//            universe.printUniverse();
            universe.nextGen();
        }
        universe.printUniverse();
        //        System.out.println(universe.sumOfNeighbors(1, 2));
//        universe.nextGen();
//
//        universe.printUniverse();
    }
}