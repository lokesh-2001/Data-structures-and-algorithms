// check if a binary tree is heap
public class checkBinaryIsHeap {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static int count(Node root){
        if(root == null)
            return 0;
        return (1 + count(root.left) + count(root.right));
    }
    // function to check if the tree is complete
    static boolean complete(Node root, int index, int count){
        if(root == null)
            return true;
        if(index >= count)
            return false;
        return complete(root.left,2*index+1, count) && complete(root.right,2*index+2, count);
    }
    static boolean heapUtil(Node root){
        if(root.left == null && root.right == null)
            return true;
        if(root.right == null)
            return root.data >= root.left.data;
        else
            if(root.data >= root.left.data && root.data >= root.right.data)
                return heapUtil(root.left) && heapUtil(root.right);
            else
                return false;
    }
    static boolean checkHeap(Node root){
        if(root == null)
            return true;
        if(complete(root, 0, count(root)) && heapUtil(root))
            return true;
        return false;
    } 
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);
 
        if (checkHeap(root) == true)
            System.out.println(
                "Given binary tree is a Heap");
        else
            System.out.println(
                "Given binary tree is not a Heap");   
    }
}
