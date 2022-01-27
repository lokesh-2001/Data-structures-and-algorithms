// Expression contains redundant bracket or not
// A set of parenthesis are redundant if the same sub-expression 
// is surrounded by unnecessary or multiple brackets. Print 'Yes' if redundant, else 'No'.
// Note: Expression may contain '+', '*', '–' and '/' operators. Given expression 
// is valid and there are no white spaces present.

import java.util.Stack;

public class RedundantBracket {
    static void check(String s){
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        for(char ch : str){
            if(ch == ')'){
                char top = st.pop();
                // if immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;
                while(top!='('){
                    if(top == '*' || top == '-'  || top == '+' ||top == '/' )
                        flag = false;
                    top = st.pop();
                }
                if(flag){
                    System.out.println("Yes");
                    return;
                }
            }
            else{
                st.push(ch);
            }
        }
        System.out.println("No");
        return;
    }   
    public static void main(String[] args) {
        String str = "((a+b))";
        check(str);
 
        str = "(a+(b)/c)";
        check(str);
 
        str = "(a+b*(c-d))";
        check(str);
    }
}
