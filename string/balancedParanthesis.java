import java.util.*;

public class balancedParanthesis {
    static boolean check(String str) {
        Deque<Character> st = new ArrayDeque<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
                continue;
            }
            if (st.isEmpty())
                return false;
            char check;
            switch (ch) {
                case ')':
                    check = st.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = st.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = st.pop();
                    if (check == '{' || check == '(')
                        return false;
                    break;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String expr = "([{}])";

        // Function call
        if (check(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
