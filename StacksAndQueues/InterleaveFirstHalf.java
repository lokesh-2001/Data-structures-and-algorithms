
// Interleave the first half of the queue with second half
// 1.Push the first half elements of queue to stack.
// 2.Enqueue back the stack elements.
// 3.Dequeue the first half elements of the queue and enqueue them back.
// 4.Again push the first half elements into the stack.
// 5.Interleave the elements of queue and stack.
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class InterleaveFirstHalf {
    static void interleave(Queue<Integer> q) {
        if (q.size() % 2 != 0) {
            System.out.println("Input even number of integers");
            return;
        }
        Stack<Integer> s = new Stack<Integer>();
        int half = q.size() / 2;
        for (int i = 0; i < half; i++)
            s.push(q.poll());
        while (!s.isEmpty())
            q.add(s.pop());
        for (int i = 0; i < half; i++)
            q.add(q.poll());
        for (int i = 0; i < half; i++)
            s.push(q.poll());
        
        while (!s.isEmpty()) {
            q.add(s.pop());
            q.add(q.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);
        q.add(15);
        q.add(16);
        q.add(17);
        q.add(18);
        q.add(19);
        q.add(20);
        System.out.println("Before Reversal");
        System.out.println(q);

        interleave(q);

        System.out.println("After Reversal");
        System.out.println(q);
    }
}
