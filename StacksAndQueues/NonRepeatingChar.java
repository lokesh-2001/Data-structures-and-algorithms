
// Queue based approach for first non-repeating character in a stream
import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingChar {
    final static int MAX = 26;

    static void firstNonRepeatingChar(String str) {
        int[] count = new int[MAX];
        Queue<Character> q = new LinkedList<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            count[ch - 'a']++;
            while (!q.isEmpty()) {
                if (count[q.peek() - 'a'] > 1)
                    q.remove();
                else {
                    System.out.print(q.peek() + " ");
                    break;
                }
            }
            if(q.isEmpty())
                System.out.print(-1 + " ");
        }
    }
    public static void main(String[] args) {
        firstNonRepeatingChar("aabc");
    }
}
