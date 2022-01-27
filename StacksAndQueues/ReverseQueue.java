
// Reverse a Queue using recursion
import java.util.Queue;
import java.util.LinkedList;

public class ReverseQueue {
    static Queue<Integer> reverse(Queue<Integer> q) {
        if (q.isEmpty())
            return q;
        int d = q.remove();
        q = reverse(q);
        q.add(d);
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(56);
        q.add(27);
        q.add(30);
        q.add(45);
        q.add(85);
        q.add(92);
        q.add(58);
        q.add(80);
        q.add(90);
        q.add(100);
        System.out.println("After Reversal");
        System.out.println(q);
        reverse(q);
        System.out.println();
        System.out.println("After Reversal");
        System.out.println(q);
    }
}
