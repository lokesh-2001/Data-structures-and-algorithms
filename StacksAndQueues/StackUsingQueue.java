// Implement Stack using Queue
import java.util.Queue;
import java.util.LinkedList;
public class StackUsingQueue {
    static Queue<Integer> q1 = new LinkedList<Integer>();
    static Queue<Integer> q2 = new LinkedList<Integer>();
    static int currSize;
    StackUsingQueue(){
        currSize = 0;
    }
    static void push(int x){
        currSize++;
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.remove();
        }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }
    static void pop(){
        if(q1.isEmpty())
            return;
        q1.remove();
        currSize--;
    }
    static int top(){
        if(q1.isEmpty())
            return -1;
        return q1.peek();
    }
    static int size(){
        return currSize;
    }
    public static void main(String[] args)
    {
        push(1);
        push(2);
        push(3);
 
        System.out.println("current size: " + size());
        System.out.println(top());
        pop();
        System.out.println(top());
        pop();
        System.out.println(top());
 
        System.out.println("current size: " + size());
    }

}
