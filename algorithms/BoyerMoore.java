// Boyer Moore Algorithm
public class BoyerMoore {
    static int noChars = 256;

    static void CharTable(char[] str, int size, int charArr[]) {
        for (int i = 0; i < noChars; i++)
            charArr[i] = -1;
        // Fill the actual value of last occurrence
        // of a character
        // CharArr
        // (indices of table are ascii and values are index of occurrence)
        for (int i = 0; i < size; i++)
            charArr[(int) str[i]] = i;
    }

    static void search(char text[], char pattern[]) {
        int m = pattern.length;
        int n = text.length;
        int charArr[] = new int[noChars];
        CharTable(pattern, m, charArr);

        int s = 0;
        // s is shift of the pattern with respect to text

        while (s <= (n - m)) {
            int j = m - 1;
            while (j >= 0 && pattern[j] == text[s + j])
                j--;
            // if the patterns is present at the current shift, then
            // index j will become -1 after above loop;

            if (j < 0) {
                System.out.println("Patterns occur at shift: " + s);

                /*
                Shift the pattern so that the next
                character in text aligns with the last
                occurrence of it in pattern.
                The condition s+m < n is necessary for
                the case when pattern occurs at the end
                of text
                 */
                // txt[s+m] is character after the pattern in text
                s += (s + m < n) ? m - charArr[text[s + m]] : 1;
            } else {
                /*
                Shift the pattern so that the bad character
                in text aligns with the last occurrence of
                it in pattern. The max function is used to
                make sure that we get a positive shift.
                We may get a negative shift if the last
                occurrence of bad character in pattern
                is on the right side of the current
                character.
                 */
                s += Math.max(1, j - charArr[text[s + j]]);
            }
        }
    }

    public static void main(String[] args) {
        char txt[] = "ABAAABCD".toCharArray();
        char pat[] = "ABC".toCharArray();
        search(txt, pat);
    }
}
