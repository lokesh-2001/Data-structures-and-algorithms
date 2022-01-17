// Longest Possible Route in a Matrix with Hurdles
public class LongestRouteInMatrix {
    static int R = 3;
    static int C = 10;

    static class Pair {
        // true if dest found
        boolean found;
        // stores cost of longest path from current cell to destination cell
        int val;

        Pair(boolean x, int y) {
            found = x;
            val = y;
        }
    }
    // source -> (i,j)
    // destination -> (x,y)

    static Pair util(int mat[][], int i, int j, int x, int y, boolean visited[][]) {
        if (i == x && j == y)
            return new Pair(true, 0);
        if (i < 0 || i >= R || j < 0 || j >= C || mat[i][j] == 0 || visited[i][j])
            return new Pair(false, Integer.MAX_VALUE);

        visited[i][j] = true;
        int res = Integer.MIN_VALUE;
        Pair sol = util(mat, i, j - 1, x, y, visited);
        if (sol.found)
            res = Math.max(sol.val, res);
        sol = util(mat, i, j + 1, x, y, visited);
        if (sol.found)
            res = Math.max(sol.val, res);
        sol = util(mat, i - 1, j, x, y, visited);
        if (sol.found)
            res = Math.max(sol.val, res);
        sol = util(mat, i + 1, j, x, y, visited);
        if (sol.found)
            res = Math.max(sol.val, res);

        visited[i][j] = false;
        if (res != Integer.MIN_VALUE)
            return new Pair(true, res + 1);
        // destination cnt be reached
        else
            return new Pair(false, Integer.MAX_VALUE);
    }

    static void base(int mat[][], int i, int j, int x, int y) {

        boolean visited[][] = new boolean[R][C];
        Pair p = util(mat, i, j, x, y, visited);
        if (p.found)
            System.out.println("Length of longest possible route is " + p.val);
        else
            System.out.println("Destination not reachable from given source");
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        // find longest path with source (0, 0) and
        // destination (1, 7)
        base(mat, 0, 0, 1, 7);
    }
}
