package gameoflife;

import java.util.Random;

public class Universe {
    public static void createGrid(
        int N,
        int S,
        char[][] genOne) {
        // declare and seed rng
        Random rng = new Random(S);
        // string to load in the characters
        boolean check = true;
        char unit = 'a';
        //          loop to fill the array
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                check = rng.nextBoolean();
                unit = getChar(check);
                genOne[i][j] = unit;
                System.out.print(genOne[i][j]);
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
}
