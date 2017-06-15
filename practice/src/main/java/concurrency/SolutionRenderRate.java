package concurrency;

import java.util.Scanner;

/**
 * Created by phandung on 6/14/17.
 */
public class SolutionRenderRate {

    /**
     * Rotate formula
     * (x, y) -> (y, N - x)
     * Transition formula
     * (x, y) -> (x + dx, y + dy)
     */
    static void rotate(int N, int[] command, int[] position){
        int dxy = command[2];
        int dRow = position[0] - command[0];
        int dCol = position[1] - command[1];

        //After rotate
        position[0] = command[0] + dCol;
        position[1] = command[1] + dxy - dRow;
    }

    static int[] solve(int N, int[][] commands, int value) {
        // 1-based index
        int valueR = value/N + 1;
        int valueC = value%N + 1;

        int[] position = new int[]{valueR, valueC};
        for(int i = 0; i < commands.length; i++){
            rotate(N, commands[i], position);
        }

        return position;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();
        int[][] commands = new int[S][3];
        for(int i = 0; i < S; i++){
            commands[i][0] = in.nextInt();
            commands[i][1] = in.nextInt();
            commands[i][2] = in.nextInt();
        }

        int L = in.nextInt();
        int[] queries = new int[L];
        for(int i = 0; i < L; i++){
            queries[i] = in.nextInt();
        }

        for (int i = 0; i < L; i++) {
            int[] result = solve(N, commands, queries[i]);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
