// Implement a method to insert an element at its bottom without using any other data structure.
import java.util.Stack;
public class InsertAtBottom {
    // * method 1
    static void insertBottom(Stack<Integer> st, int n){
        Stack<Integer> temp = new Stack<Integer>();
        while(!st.empty()){
            temp.push(st.pop());
        }
        st.push(n);
        while(!temp.empty()){
            st.push(temp.pop());
        }
        // print the stack
        while(!st.empty())
            System.out.print(st.pop() + " ");

    }

    // * method 2
    static Stack<Integer> util(Stack<Integer> st, int n){
        if(st.size() == 0)
            st.push(n);
        else{
            int x = st.pop();
            st = util(st,n);
            st.push(x);
        }
        return st;
    }
    static void base(Stack<Integer>s, int n){
        s = util(s,n);
        while(s.size()>0)
            System.out.print(s.pop() + " ");
    }
    public static void main(String[] args) {
        
        // Stack for method 1
        Stack<Integer> S1 = new Stack<Integer>();
        S1.push(5);
        S1.push(4);
        S1.push(3);
        S1.push(2);
        S1.push(1);
        // Stack for method 2
        Stack<Integer> S2 = new Stack<Integer>();
        S2.push(5);
        S2.push(4);
        S2.push(3);
        S2.push(2);
        S2.push(1);
      
        int N = 6;
        System.out.println("Method 1");
        insertBottom(S2,N);
        System.out.println();
        System.out.println("Method 2");
        base(S1, N);
    }

}
