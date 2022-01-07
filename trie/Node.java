public class Node {
    final int SIZE = 26;
    Node[] children = new Node[SIZE];
    boolean isEndOfWord;
    Node(){
        isEndOfWord = false;
        for(int i = 0;i<SIZE;i++)
            children[i] = null;
    }
     void insert(Node root, String key){
        int length = key.length();
        int index;
        Node temp = root;
        for(int i=0;i<length;i++){
            index = key.charAt(i) - 'a';
            if(temp.children[index] == null)
                temp.children[index] = new Node();
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
    }
     boolean search(Node root, String key){
        int length = key.length();
        int index;
        Node temp = root;
        for(int i=0;i<length;i++){
            index = key.charAt(i) - 'a';
            if(temp.children[index] == null)
                return false; 
            temp = temp.children[index];
        }
        return temp!=null &&temp.isEndOfWord;
    }
    
     Node remove(Node root, String key, int depth){
        if(root == null)
            return root;
        // if last character of key is being processed
        if(depth == key.length()){
            if(root.isEndOfWord)
                root.isEndOfWord = false;
            if(isEmpty(root))
                root = null;    
            return root;
        }
        int index = key.charAt(depth) -'a';
        root.children[index] = remove(root.children[index], key, depth+1);
        if(isEmpty(root) && root.isEndOfWord == false)
            root = null;
        return root;
    }
     boolean isEmpty(Node root){
        for(int i =0 ;i<root.SIZE;i++)
            if(root.children[i]!=null)
                return false;
        return true;
    }

}
