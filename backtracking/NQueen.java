public class NQueen {
    static int N = 4;

    // this function is called when "col" queens have been placed in columns from 0
    // to col-1
    // so left side of queens are checked
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        // for upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        // for lower diagonal on left side
        for (i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    static boolean util(int board[][], int col) {
        if (col >= N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (util(board, col + 1))
                    return true;
                board[i][col] = 0;
            }
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

    public static void main(String[] args) {
        int board[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (!util(board, 0))
            System.out.print("Solution does not exist");
        else
            print(board);
    }
}