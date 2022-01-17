// The Knight's tour problem
// Given a N*N board with the Knight 
// placed on the first block of an empty board. 
// Moving according to the rules of chess knight must 
// visit each square exactly once. Print the order of 
// each cell in which they are visited.
public class KnightTourProblem {
    static int N = 8;

    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && y >= 0 && x < N && y < N && sol[x][y] == -1);
    }

    static void base() {
        int sol[][] = new int[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
        int x[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int y[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        sol[0][0] = 0;
        if (!util(0, 0, 1, sol, x, y)) {
            System.out.println("Solution doesn't exist");
            return;
        } else
            printSol(sol);
    }

    static boolean util(int X, int Y, int move, int sol[][], int x[], int y[]) {
        int k, nextX, nextY;
        if (move == N * N)
            return true;
        for (k = 0; k < 8; k++) {
            nextX = X + x[k];
            nextY = Y + y[k];
            if (isSafe(nextX, nextY, sol)) {
                sol[nextX][nextY] = move;
                if (util(nextX, nextY, move + 1, sol, x, y))
                    return true;
                sol[nextX][nextY] = -1;
            }
        }
        return false;
    }

    static void printSol(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        base();
    }
}

// worst running time is O((8^N)^2).
