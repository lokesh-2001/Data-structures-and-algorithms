
// Given a sequence of words, print all anagrams together
// 1) Create an empty Trie 
// 2) One by one take all words of input sequence. Do following for each word 
// …a) Copy the word to a buffer. 
// …b) Sort the buffer 
// …c) Insert the sorted buffer and index of this word to Trie. Each leaf node of 
// Trie is head of a Index list. The Index list stores index of words in original sequence. 
// If sorted buffer is already present, we insert index of this word to the index list. 
// 3) Traverse Trie. While traversing, if you reach a leaf node, traverse the index list. 
// And print all words using the index obtained from Index list. 
import java.util.Arrays;
import java.util.LinkedList;

public class Anagrams {
    static final int NoOfChars = 26;

    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[NoOfChars];
        LinkedList<Integer> head;

        TrieNode() {
            isEndOfWord = false;
            head = new LinkedList<>();
            for (int i = 0; i < NoOfChars; i++)
                children[i] = null;
        }
    };

    static TrieNode insert(TrieNode root, String word, int index, int i) {
        if (root == null)
            root = new TrieNode();
        if (i < word.length()) {
            int temp = word.charAt(i) - 'a';
            root.children[temp] = insert(root.children[temp], word, index, i + 1);
        } else {
            if (root.isEndOfWord)
                root.head.add(index);
            else {
                root.isEndOfWord = true;
                root.head.add(index);
            }
        }
        return root;
    }

    static void util(TrieNode root, String word[]) {
        if (root == null)
            return;
        if (root.isEndOfWord)
            for (Integer temp : root.head)
                System.out.println(word[temp]);

        for (int i = 0; i < NoOfChars; i++)
            util(root.children[i], word);
    }

    static void base(String word[], int n) {
        TrieNode root = null;
        for (int i = 0; i < n; i++) {
            char[] temp = word[i].toCharArray();
            Arrays.sort(temp);
            root = insert(root, new String(temp), i, 0);
        }
        util(root, word);
    }

    public static void main(String[] args) {
        String wordArr[] = { "cat", "dog", "tac", "god",
                "act", "gdo" };
        int size = wordArr.length;
        base(wordArr, size);
    }
}