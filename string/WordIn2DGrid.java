// search a word in a 2D grid of characters
public class WordIn2DGrid {
    static int R = 3, C = 13;

    // for searching in all 8 directions
    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static boolean searchIn2D(char[][] grid, int row, int col, String word) {
        // if first char doesn't match with given starting point in grid
        if (grid[row][col] != word.charAt(0))
            return false;
        int len = word.length();

        // search word in all 8 directions

        for (int dir = 0; dir < 8; dir++) {
            int k, rd = row + x[dir], cd = col + y[dir];

            for (k = 1; k < len; k++) {
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;
                if (grid[rd][cd] != word.charAt(k))
                    break;
                rd += x[dir];
                cd += y[dir];
            }

            // if all characters are matched then k must be equal to len of word
            if (k == len)
                return true;
        }
        return false;
    }

    static void searchBase(char[][] grid, String word) {
        for (int row = 0; row < R; row++)
            for (int col = 0; col < C; col++)
                if (searchIn2D(grid, row, col, word))
                    System.out.println("Pattern Found At : {" + row + "," + col + "}");
    }

    public static void main(String[] args) {
        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
        searchBase(grid, "GEEKS");
        System.out.println();
        searchBase(grid, "EEE");

    }
}
