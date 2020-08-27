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
        System.out.println();
    }
    // gets the count of neighbors, used to check if a cell in the next generation is alive or not
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
            top = dimensions - 1;
        }
        // if we are at the bottom of the field, bot will be at the top
        if (row == dimensions - 1) {
            bot = 0;
        }
        // if we are at the left of the field, left will be the right border~
        if (column == 0) {
            left = dimensions - 1;
        }
        // if we are at the right of the field, right will be the left border
        if (column == dimensions - 1) {
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
    /*
    create the next generation of the board. If the node is alive and it has 2 or 3
    neighbors, it stays alive. If the node is dead it comes to life if it has exactly
    3 neighbors.
    if a node has 3 neighbors it is always alive. if a node has 2 neighbors and is alive
    it stays alive. Otherwise the node is always dead.
     */
    public void nextGen() {
        int[][] newGen = new int[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                int count = sumOfNeighbors(i, j);
                if (count == 3) {
                    newGen[i][j] = 1;
                }else if (count == 2 && this.state[i][j] == 1) {
                    newGen[i][j] = 1;
                }else {
                    newGen[i][j] = 0;
                }
            }
        }
        this.state = newGen;
    }

    // set living and dead states for testing and initial conditions
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
