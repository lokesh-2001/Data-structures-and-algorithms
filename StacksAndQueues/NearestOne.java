
// Distance of nearest cell having 1 in a binary matrix
import java.util.LinkedList;
import java.util.Queue;

public class NearestOne {
    static class Pos {
        int row, col;

        Pos(int i, int j) {
            row = i;
            col = j;
        }
    }

    static boolean isValid(int i, int j, int R, int C) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    static void minDist(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans[][] = new int[n][m];
        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == 1)
                    q.add(new Pos(i, j));
        int min = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pos curr = q.poll();
                ans[curr.row][curr.col] = min;
                int x, y;

                // left
                x = curr.row - 1;
                y = curr.col;
                if (isValid(x, y, n, m)) {
                    if (matrix[x][y] == 0) {
                        q.add(new Pos(x, y));
                        matrix[x][y] = 1;
                    }
                }

                // right
                x = curr.row + 1;
                y = curr.col;
                if (isValid(x, y, n, m)) {
                    if (matrix[x][y] == 0) {
                        q.add(new Pos(x, y));
                        matrix[x][y] = 1;
                    }
                }

                // top
                x = curr.row;
                y = curr.col + 1;
                if (isValid(x, y, n, m)) {
                    if (matrix[x][y] == 0) {
                        q.add(new Pos(x, y));
                        matrix[x][y] = 1;
                    }
                }
                // down
                x = curr.row;
                y = curr.col - 1;
                if (isValid(x, y, n, m)) {
                    if (matrix[x][y] == 0) {
                        q.add(new Pos(x, y));
                        matrix[x][y] = 1;
                    }
                }
            }
            min++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix1[][] = new int[][] {
                { 0, 1, 0 },
                { 0, 0, 0 },
                { 1, 0, 0 }
        };
        minDist(matrix1);
        System.out.println();
        int matrix2[][] = new int[][] {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 1, 0, 1 }
        };
        minDist(matrix2);

    }
}
