// Length of the Longest Valid Substring
import java.util.Stack;
public class LongestValidSubstring {
    static int findLength(String str){
        int n =  str.length();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int result = 0;
        for(int i=0;i<n;i++){
            if(str.charAt(i) == '(')
                st.push(i);
            else{
                if(!st.isEmpty())
                    st.pop();
                if(!st.isEmpty())
                    result = Math.max(result,i-st.peek());
                else
                    st.push(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "((()()";
       
        // Function call
        System.out.println(findLength(str));
 
        str = "()(()))))";
       
        // Function call
        System.out.println(findLength(str));
    }
}
