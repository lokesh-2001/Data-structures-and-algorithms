import java.util.HashMap;
public class PhoneDirectory {
    static class TrieNode{
        HashMap<Character,TrieNode> children;
        boolean isEndOfWord;
        TrieNode(){
            children = new HashMap<Character,TrieNode>();
            for(char i = 'a';i<='z';i++)
                  children.put(i,null);
            isEndOfWord = false;
        }
    }
    static TrieNode root;
    static void insertIntoTrie(String contacts[]){
        root = new TrieNode();
        int n = contacts.length;
        for(int i =0; i<n;i++)
            insert(contacts[i]);
    }
    static void insert(String s){
        int len = s.length();
        TrieNode itr = root;
        for(int i =0 ;i<len;i++){
            TrieNode next = itr.children.get(s.charAt(i));
            if(next == null){
                next = new TrieNode();
                itr.children.put(s.charAt(i), next);
            }
            itr = next;

            if(i == len-1)
                itr.isEndOfWord = true;
        }
    }
    static void util(TrieNode curr, String prefix){
        if(curr.isEndOfWord)
            System.out.println(prefix);
        for(char i = 'a';i<='z';i++){
            TrieNode next = curr.children.get(i);
            if(next!=null)
                util(next, prefix+i);
        }
    }
    static void base(String str){
        TrieNode prev = root;
        String prefix = "";
        int len = str.length();
        int i;
        for(i = 0;i<len;i++){
            prefix += str.charAt(i);
            char last = prefix.charAt(i);
            TrieNode curr = prev.children.get(last);
            if(curr == null){
                System.out.println("No result found ");
                i++;
                break;
            } 
            util(curr, prefix);
            prev = curr;
      }    
      for(;i<len;i++){
            prefix += str.charAt(i);
            System.out.println("No results found");
      } 
    }
    public static void main(String[] args) {
        String contacts [] = {"gforgeeks", "geeksquiz"};
        insertIntoTrie(contacts);
        String query = "gekk";
          base(query);
    }
}
