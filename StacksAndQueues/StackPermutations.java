// Stack Permutations (Check if an array is stack permutation of other)
// A stack permutation is a permutation of objects in the given input queue which 
// is done by transferring elements from input queue to the output queue with the 
// help of a stack and the built-in push and pop functions.
// The well defined rules are: 

// Only dequeue from the input queue.
// Use inbuilt push, pop functions in the single stack.
// Stack and input queue must be empty at the end.
// Only enqueue to the output queue.
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackPermutations {
    static boolean check(int ip[], int op[]) {
        int n = ip.length;
        int m = op.length;
        if (n != m)
            return false;
        Queue<Integer> input = new LinkedList<>();
        for (int i = 0; i < n; i++)
            input.add(ip[i]);
        
        Queue<Integer> output = new LinkedList<>();
        for (int i = 0; i < n; i++)
            output.add(op[i]);

        Stack<Integer> temp = new Stack<>();
        while(!input.isEmpty()){
            int d = input.poll();
            if(d == output.peek()){
                output.poll();
                while(!temp.isEmpty()){
                    if(temp.peek() == output.peek()){
                        temp.pop();
                        output.poll();
                    }
                    else
                        break;
                }
            }
            else
                temp.push(d);
        }
        return (temp.isEmpty() && input.isEmpty());
    }
    public static void main(String[] args) {
        int input[] = { 1, 2, 3 };
 
        // Output Queue
        int output[] = { 2, 1, 3 };
        if (check(input, output))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
    }
}
