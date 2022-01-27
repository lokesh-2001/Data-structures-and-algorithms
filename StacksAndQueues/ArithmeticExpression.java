
// Arithmetic Expression evaluation
import java.util.Stack;

public class ArithmeticExpression {
    static boolean precedence(char a, char b) {
        if (b == '(' || b == ')')
            return false;
        if ((a == '*' || a == '/' )&& (b == '+' || b == '-'))
            return false;
        else
            return true;
    }

    static int calculate(char op, int a, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return b / a;
        }
        return 0;
    }

    static int evaluate(String str) {
        char[] exp = str.toCharArray();
        Stack<Integer> value = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == ' ')
                continue;
            if (exp[i] >= '0' && exp[i] <= '9') {
                StringBuffer s = new StringBuffer();

                // to counter the numbers having more than 1 digit
                while (i < exp.length && exp[i] >= '0' && exp[i] <= '9')
                    s.append(exp[i++]);
                value.push(Integer.parseInt(s.toString()));

                i--;
            } else if (exp[i] == '(')
                ops.push(exp[i]);
            else if (exp[i] == ')') {

                while (ops.peek() != '(')
                    value.push(calculate(ops.pop(), value.pop(), value.pop()));
                ops.pop();
            }

            else if (exp[i] == '+' || exp[i] == '-'
                    || exp[i] == '*' || exp[i] == '/') {
                while (!ops.empty() && precedence(exp[i], ops.peek()))
                    value.push(calculate(ops.pop(), value.pop(), value.pop()));
                ops.push(exp[i]);
            }
        }

        while (!ops.empty())
            value.push(calculate(ops.pop(), value.pop(), value.pop()));

        return value.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("10 + 2 * 6"));
        System.out.println(evaluate("100 * 2 + 12"));
        System.out.println(evaluate("100 * ( 2 + 12 )"));
        System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
    }

}
