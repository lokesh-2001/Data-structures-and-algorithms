public class BalancedParanthesis {
    static boolean balanced(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else
                count--;
            if (count < 0) {
                return false;
            }
        }
        if (count != 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String exp1 = "((()))()()";

        if (balanced(exp1))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

        String exp2 = "())((())";

        if (balanced(exp2))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}
