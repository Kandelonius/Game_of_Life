package gameoflife;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        // Output a random square or NxN
        int N = stdIn.nextInt(); // genOne dimensions
        long S = stdIn.nextLong(); // seed for RNG
        int generations = stdIn.nextInt(); // number of generations
        Universe universe = new Universe(N, S);
//        universe.setLiving(0,1);
//        universe.setLiving(0,2);
//        universe.setLiving(0,3);
        universe.createGrid();
        for (int i = 0; i < generations; i++) {
            universe.nextGen();
        }
        universe.printUniverse();
    }
}