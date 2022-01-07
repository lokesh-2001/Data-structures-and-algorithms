public class BasicImplementation{
    static void insert(Node root, String key){
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
    static boolean search(Node root, String key){
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
    
    static Node remove(Node root, String key, int depth){
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
    static boolean isEmpty(Node root){
        for(int i =0 ;i<root.SIZE;i++)
            if(root.children[i]!=null)
                return false;
        return true;
    }
    public static void main(String[] args) {
        // Input keys (use only 'a' through 'z'
        // and lower case)
        String keys[] = { "the", "a", "there",
                        "answer", "any", "by",
                        "bye", "their", "hero", "heroplane" };
        int n = keys.length;

        Node root = new Node();

        // Construct trie
        for (int i = 0; i < n; i++)
            insert(root, keys[i]);

        // Search for different keys
        if(search(root, "the"))
            System.out.println("Yes");
        else
            System.out.println("No");

        if(search(root, "these"))
            System.out.println("Yes");
        else
            System.out.println("No");

        remove(root, "heroplane", 0);
        
        if(search(root, "hero"))
            System.out.println("Yes");
        else
            System.out.println("No");


    }
}