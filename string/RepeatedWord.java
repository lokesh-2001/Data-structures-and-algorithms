import java.util.HashSet;

// Find the first repeated word in string.
public class RepeatedWord {
    static String find(String str) {
        String tokens[] = str.split(" ");
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i]))
                return tokens[i];
            set.add(tokens[i]);
        }
        return "-1";
    }

    public static void main(String[] args) {
        String s = "Ravi had been saying that he had been there";
        String firstWord = find(s);
        if (!firstWord.equals("-1"))
            System.out.println("First repeated word :: " + firstWord);
        else
            System.out.println("No Repetitionn");
    }
}
