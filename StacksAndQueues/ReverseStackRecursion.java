// Reverse a stack using recursion
import java.util.Stack;
public class ReverseStackRecursion {
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
    static void base(Stack<Integer>s){
        if(!s.empty()){
            int n = s.pop();
            base(s);
            util(s,n);
        }
    }
    public static void main(String[] args) {
        
        // Stack for method 1
        Stack<Integer> S = new Stack<Integer>();
        S.push(5);
        S.push(4);
        S.push(3);
        S.push(2);
        S.push(1);
        System.out.println("Original Stack: ");
        System.out.println(S);
        System.out.println();
        base(S);
        System.out.println("Reversed Stack: ");
        System.out.println(S);
    }
 
}
