public class RatInAMaze {
    static int N;

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        N = maze.length;
        SolveMaze(maze);
    }

    static void SolveMaze(int[][] maze) {
        int sol[][] = new int [N][N];
        if(!util(maze, 0, 0, sol)){
            System.out.println("Solution Does not exist");
            return;
        }
        print(sol);
    }

    static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1);
    }

    static boolean util(int[][] maze, int x, int y, int sol[][]) {
        // check for destination
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            if (sol[x][y] == 1)
                return false;
            sol[x][y] = 1;
            if (util(maze, x + 1, y, sol))
                return true;
            if (util(maze, x, y + 1, sol))
                return true;
            if (util(maze, x - 1, y, sol))
                return true;
            if (util(maze, x, y - 1, sol))
                return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    static void print(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }
}
