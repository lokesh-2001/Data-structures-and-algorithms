public class flatten {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d ;
            left = right = null;
        }
    }
    static void print(Node node){
        Node curr = node;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
    static Node prev = null;
    static void inorder(Node curr){
        if(curr == null)
            return;
        inorder(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        inorder(curr.right);
    }
    static Node flattenBST(Node node){
        Node dummy = new Node(-1);
        prev = dummy;
        inorder(node);
        prev.left = null;
        prev.right = null;
        Node ret = dummy.right;
        return ret;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        
        // Calling required function
        print(flattenBST(root));
    }
}
