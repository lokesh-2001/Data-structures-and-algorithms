// Reverse the first "K" elements of a queue
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class ReverseKElementsQueue {

    static void reverseK(Queue<Integer> q,int k){
        if(q.isEmpty() || k<=0 || k> q.size() )
            return;
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<k;i++)
            st.push(q.remove());
        while(!st.isEmpty())
            q.add(st.pop());
        for(int i=0;i<q.size()-k;i++)
            q.add(q.remove());        
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
 
        int k = 5;
        System.out.println("Before Reversal");
        System.out.println(q);
        
        reverseK(q,k);
        System.out.println("After Reversal");

        System.out.println(q);
    }
}
