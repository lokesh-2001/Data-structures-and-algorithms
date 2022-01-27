import java.util.Stack;
public class QueueUsingStack {
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();
    static void enqueue(int n){
        while(!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(n);
        while(!s2.isEmpty())
            s1.push(s2.pop());
    }
    static int dequeue(){
        if(s1.isEmpty()){
            System.out.println("Queue Empty");
        }
        return s1.pop();
    }
    public static void main(String[] args) {
        enqueue(1);
        enqueue(2);
        enqueue(3);
     
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
    }
}
