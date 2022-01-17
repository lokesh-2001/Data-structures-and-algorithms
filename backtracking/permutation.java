public class permutation {
    // swap function
    static String swap(String str, int x, int y) {
        char t;
        char[] chrArr = str.toCharArray();
        t = chrArr[x];
        chrArr[x] = chrArr[y];
        chrArr[y] = t;
        return String.valueOf(chrArr);

    }

    // finding permutation fun
    static void permutations(String str, int i, int j) {

        if (i == j) {
            System.out.print(str + " ");
            return;
        }
        for (int k = i; k <= j; k++) {
            // do
            str = swap(str, i, k);
            // recursion
            permutations(str, i + 1, j);
            // undo
            str = swap(str, i, k);
        }

    }

    static void permutations2(String s, String ans) {
        if (s.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i+1);
            String str = left + right;
            permutations2(str, ans+ch);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        String ans="";
        // string , left boundary, right boundary
        System.out.println("Method 1");
        System.out.println();
        permutations(str, 0, str.length() - 1);
        System.out.println();
        System.out.println("Method 2");
        System.out.println();
        permutations2(str, ans);
    }
}