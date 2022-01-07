// Power Set
// given a string s find all possible subsequences of string in lexicographically sorted order
public class powerSet {
    static void print(char[] set) {
        int n = set.length;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] set = { 'a', 'b', 'c' };
        print(set);
    }
}
