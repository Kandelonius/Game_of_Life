package gameoflife;

import java.util.Random;

public class Universe {
    // using only square fields so only using one dimension
    int dimensions;

    int S;

    //use int matrix for ease of state detection. boolean would also work
    int[][] state;

    // constructor for dimensions and matrix
    public Universe(
        int d,
        int s) {
        dimensions = d;
        S = s;
        this.state = new int[dimensions][dimensions];
    }

    // declare and seed rng
    Random rng = new Random(S);

    boolean check = true;

    char unit = 'a';

    //          loop to fill the array
    //    for (int i = 0; i < dimensions; i++) {
    //        for (int j = 0; j < dimensions; j++) {
    //            check = rng.nextBoolean();
    //            unit = getChar(check);
    //            genA[i][j] = unit;
    //            System.out.print(genA[i][j]);
    //        }
    //        System.out.println();
    //    }
    //    public static void createGrid(
    //        int dimensions,
    //        int S,
    //        char[][] genA) {
    // declare and seed rng
    //        Random rng = new Random(S);
    // string to load in the characters
    //        boolean check = true;
    //        char unit = 'a';

    public void printUniverse() {
        for (int i = 0; i < dimensions; i++) {
            String row = "|";
            for (int j = 0; j < dimensions; j++) {
                if (this.state[i][j] == 0) {
                    //                    System.out.print(0);
                    //                    check = rng.nextBoolean();
                    //                    row += getChar(check);
                    row += "+";
                } else {
                    //                    System.out.print(1);
                    //                    check = rng.nextBoolean();
                    //                    row += getChar(check);
                    row += "Y";
                }
            }
            row += "|";
            System.out.println(row);
        }
    }

    public int sumOfNeighbors(
        int row,
        int column,
        int dimensions) {
        int count = 0;
        int left = column - 1;
        int top = row + 1;
        int right = column + 1;
        int bot = row + 1;

        // if we are at the top of the field, top will be the bottom
        if (row == 0) {
            top = dimensions - 1;
        }
        // if we are at the bottom of the field, bot will be at the top
        if (row == dimensions - 1) {
            bot = 0;
        }
        // if we are at the left of the field, left will be the right border
        if (column == 0) {
            left = dimensions - 1;
        }
        // if we are at the right of the field, right will be the left border
        if (column == dimensions - 1) {
            right = 0;
        }

        return count;
    }

    // set living and dead states for testing
    public void setliving(
        int row,
        int column) {
        this.state[row][column] = 1;
    }

    public void setDead(
        int row,
        int column) {
        this.state[row][column] = 0;
    }

    //          loop to fill the array
    //        for (int i = 0; i < N; i++) {
    //            for (int j = 0; j < N; j++) {
    //                check = rng.nextBoolean();
    //                unit = getChar(check);
    //                genA[i][j] = unit;
    //                System.out.print(genA[i][j]);
    //            }
    //            System.out.println();
    //        }
    //    }
    public static String getChar(boolean b) {
        if (b) {
            return "+";
        } else {
            return "Y";
        }
    }
}
