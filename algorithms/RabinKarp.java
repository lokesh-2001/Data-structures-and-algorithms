// Rabin Karp Algorithm for Pattern Searching
public class RabinKarp {
    static final int d = 256;

    // q is a prime number
    static void search(String pattern, String text, int q) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;

        // calculate the hash value of pattern and first window of text
        for (i = 0; i < m; i++){
            p = (d*p + pattern.charAt(i))%q;
            t = (d*t + text.charAt(i))%q;
        }



        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++)
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                if (j == m)
                    System.out.println("Pattern Found At: " + i);
            }
            if (i < n - m) {
                // calculate the hash value for next window of text
                // remove the leading digit and add trailing digit

                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0)
                    t += q;
            }
        }
    }

    public static void main(String[] args) {
        String txt = "Hello world Hello";
        String pat = "Hello";
        int q = 101;
        search(pat, txt, q);
    }
}
