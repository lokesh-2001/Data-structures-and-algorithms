public class ShortestUniquePrefix {
    static final int MAX = 256;
    static final int MAMX_WORD_LEN = 500;
    static class TrieNode{
        TrieNode[] children = new TrieNode[MAX];
        int freq;
        TrieNode(){
            freq = 1;
            for(int i =0;i<MAX;i++)
                children[i] = null;
        }
    }   
    static TrieNode root;
    static void insert(String str){
        int len  = str.length();
        TrieNode temp = root;
        for(int i=0;i<len;i++){
            int index = str.charAt(i);
            if(temp.children[index] == null)
                temp.children[index] = new TrieNode();
            else
                temp.children[index].freq++;
            
            temp = temp.children[index];
        }
    }
    static void util(TrieNode root, char[] prefix, int index){
        if(root == null)
            return;
        if(root.freq == 1){
            prefix[index] = '\0';
            int i = 0;
            while(prefix[i]!='\0')
                System.out.print(prefix[i++]);
            System.out.println();
            return;
        }
        for(int i = 0;i<MAX;i++){
            if(root.children[i] != null){
                prefix[index] = (char) i;
                util(root.children[i], prefix, index+1);
            }

        }
    }
    static void base(String arr[], int n){
        root = new TrieNode();
        root.freq = 0;
        for(int i =0 ;i<n;i++)
            insert(arr[i]);
        char[] prefix = new char[MAMX_WORD_LEN];
        util(root, prefix, 0);
    }    
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        int n = arr.length;
        base(arr, n);
    }
}
