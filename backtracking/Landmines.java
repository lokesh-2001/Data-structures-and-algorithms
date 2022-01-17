
// Find shortest safe route in a path with landmines
import java.util.Arrays;

public class Landmines {

    static final int R = 12;
    static final int C = 10;

    static int xMove[] = { -1, 0, 0, 1 };
    static int yMove[] = { -0, -1, 1, 0 };

    static int minDist;

    static boolean isSafe(int[][] mat, boolean[][] visited, int x, int y) {
        return (!(mat[x][y] == 0 || visited[x][y]));
    }

    static boolean isValid(int x, int y) {
        return (x >= 0 && y >= 0 && x < R && y < C);
    }

    // function to mark all the adjacent cells of landmines as unsafe cells
    static void unsafe(int[][] mat) {
        for (int x = 0; x < R; x++)
            for (int y = 0; y < C; y++)
                if (mat[x][y] == 0) {
                    for (int k = 0; k < 4; k++)
                        if (isValid(x + xMove[k], y + yMove[k]))
                            mat[x + xMove[k]][y + yMove[k]] = -1;
                }
        // mark all found adjacent cells as unsafe
        for (int x = 0; x < R; x++)
            for (int y = 0; y < C; y++)
                if (mat[x][y] == -1)
                    mat[x][y] = 0;

        // print new mat
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++)
                System.out.print(mat[x][y] + " ");
            System.out.println();
        }
    }

    static void util(int[][] mat, boolean[][] visited, int x, int y, int dist) {
        if (y == C - 1) {
            minDist = Math.min(minDist, dist);
            return;
        }
        if (dist > minDist)
            return;
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            if (isValid(x + xMove[k], y + yMove[k]) &&
                    isSafe(mat, visited, x + xMove[k], y + yMove[k]))
                util(mat, visited, x + xMove[k], y + yMove[k], dist + 1);

        }
        visited[x][y] = false;
    }

    static void base(int[][] mat) {
        minDist = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[R][C];
        unsafe(mat);

        for (int x = 0; x < R; x++) {
            if (mat[x][0] == 1) {
                for (int k = 0; k < R; k++)
                    Arrays.fill(visited[k], false);

                util(mat, visited, x, 0, 0);
                if (minDist == C - 1)
                    break;
            }
        }
        if (minDist != Integer.MAX_VALUE)
            System.out.println("Length of shortest safe route is " + minDist);

        else
            System.out.println("Destination not reachable from given source");

    }

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };

        base(mat);
    }

}
