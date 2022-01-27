import java.util.Stack;

public class PostfixEvaluation {
    static int evaluate(String exp) {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c==' ')
                continue;
            // for a number to have multiple digits
            else if (Character.isDigit(c)){
                int n=0;
                while(Character.isDigit(c)){
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;
                st.push(n);
            }
            
            
            else {
                int a = st.pop();
                int b = st.pop();
                switch (c) {
                    case '+':
                        st.push(a + b);
                        break;
                    case '-':
                        st.push(b - a);
                        break;
                    case '*':
                        st.push(a * b);
                        break;
                    case '/':
                        if (a == 0)
                            throw new UnsupportedOperationException("Cannot divide by zero");

                        st.push(b / a);
                        break;
                }
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        System.out.println("postfix evaluation: "+evaluate("100 200 + 2 / 5 * 7 +"));
    }
}
