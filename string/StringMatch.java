// String matching where one string contains wildcard characters
// '*' --> Matches with 0 or more instances of any character or set of characters.
// '?' --> Matches with any one character.
public class StringMatch {
    static boolean match(String first, String second) {
        if (first.length() == 0 && second.length() == 0)
            return true;
        if (first.length() > 1 && first.charAt(0) == '*' && second.length() == 0)
            return false;

        if ((first.length() > 1 && first.charAt(0) == '?') ||
                (first.length() != 0 && second.length() != 0 &&
                        first.charAt(0) == second.charAt(0)))
            return match(first.substring(1), second.substring(1));

        if (first.length() > 0 && first.charAt(0) == '*')
            return (match(first.substring(1), second) ||
                    match(first, second.substring(1)));
        return false;
    }

    // A function to run test cases
    static void test(String first, String second) {
        if (match(first, second))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void main(String[] args) {
        test("*pqrs", "pqrst"); // No because 't' is not in first
        test("abc*bcd", "abcdhghgbcd"); // Yes
        test("abc*c?d", "abcd"); // No because second must have 2
                                 // instances of 'c'
        test("*c*d", "abcd"); // Yes
        test("*?c*d", "abcd"); // Yes
    }
}
