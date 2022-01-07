// Given an input string and a dictionary of words, find out if 
// the input string can be segmented into a space-separated sequence 
// of dictionary words. 

// E.g.
// Consider the following dictionary 
// { i, like, sam, sung, samsung, mobile, ice, 
//   cream, icecream, man, go, mango}

// Input:  ilike
// Output: Yes 
// The string can be segmented as "i like".

public class WordBreak {
    static boolean find(String str, Node root) {
        int n = str.length();
        if (n == 0)
            return true;
        // The parameter for search is
        // str.substring(0, i) which is
        // prefix (of input string) of
        // length 'i'. We first check whether
        // current prefix is in dictionary.
        // Then we recursively check for remaining
        // string str.substr(i, size) which
        // is suffix of length size-i.
        for (int i = 1; i <= n; i++)
            if (root.search(root, str.substring(0, i))
                    && find(str.substring(i, n), root))
                return true;
        return false;
    }

    public static void main(String[] args) {
        String dictionary[] = { "mobile", "samsung",
                "sam", "sung", "ma",
                "mango", "icecream",
                "and", "go", "i", "like",
                "ice", "cream" };

        int n = dictionary.length;
        Node root = new Node();

        // Construct trie
        for (int i = 0; i < n; i++)
            root.insert(root, dictionary[i]);

        System.out.print(find("ilikesamsung", root) ? "Yes\n" : "No\n");
        System.out.print(find("iiiiiiii", root) ? "Yes\n" : "No\n");
        System.out.print(find("", root) ? "Yes\n" : "No\n");
        System.out.print(find("ilikelikeimangoiii", root) ? "Yes\n" : "No\n");
        System.out.print(find("samsungandmango", root) ? "Yes\n" : "No\n");
        System.out.print(find("samsungandmangok", root) ? "Yes\n" : "No\n");
    }
}
