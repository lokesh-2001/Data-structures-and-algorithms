// Count of number of given string in 2D character array
public class CountIn2DArray {
    static int searchUtil(String needle, int row, int col, String arr[], int rowMax, int colMax, int xx) {
        int found = 0;
        if (row >= 0 && row <= rowMax && col >= 0 && col <= colMax
                && xx < needle.length() && needle.charAt(xx) == arr[row].charAt(col)) {

            char match = needle.charAt(xx);
            xx += 1;

            arr[row] = arr[row].substring(0, col) + "0" + arr[row].substring(col + 1);
            if (xx == needle.length())
                found = 1;
            else {
                found += searchUtil(needle, row, col + 1, arr, rowMax, colMax, xx);
                found += searchUtil(needle, row, col - 1, arr, rowMax, colMax, xx);
                found += searchUtil(needle, row + 1, col, arr, rowMax, colMax, xx);
                found += searchUtil(needle, row - 1, col, arr, rowMax, colMax, xx);
            }
            arr[row] = arr[row].substring(0, col) + match + arr[row].substring(col + 1);
        }
        return found;
    }

    static int searchBase(String needle, int row, int col, String str[], int rowCount, int colCount) {
        int found = 0;
        int r, c;
        for (r = 0; r < rowCount; r++)
            for (c = 0; c < colCount; c++)
                found += searchUtil(needle, r, c, str, rowCount - 1, colCount - 1, 0);
        return found;
    }

    public static void main(String[] args) {
        String needle = "MAGIC";
        String input[] = { "BBABBM", "CBMBBA",
                "IBABBG", "GOZBBI",
                "ABBBBC", "MCIGAM" };
        String str[] = new String[input.length];
        int i;
        for (i = 0; i < input.length; ++i) {
            str[i] = input[i];
        }

        System.out.println("count: " +
                searchBase(needle, 0, 0, str,
                        str.length,
                        str[0].length()));
    }
}
