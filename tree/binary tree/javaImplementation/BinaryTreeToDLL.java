package javaImplementation;
// If the left subtree exists, process the left subtree
    // # Recursively convert the left subtree to DLL.
    // # Then find the inorder predecessor of the root in the left subtree (the inorder predecessor is the rightmost node in the left subtree).
    // # Make the inorder predecessor as the previous root and the root as the next in order predecessor.
//  If the right subtree exists, process the right subtree (Below 3 steps are similar to the left subtree).
    // # Recursively convert the right subtree to DLL.
    // # Then find the inorder successor of the root in the right subtree (in order the successor is the leftmost node in the right subtree).
    // # Make the inorder successor as the next root and the root as the previous inorder successor.
// Find the leftmost node and return it (the leftmost node is always the head of a converted DLL).
public class BinaryTreeToDLL {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right =null;
        }
    }
    static Node util(Node node){
        if(node == null)
            return node;
        if(node.left!=null){
            Node left = util(node.left);
            for(; left.right!=null; left = left.right);
            left.right  = node;
            node.left = left;
        }
        if(node.right!=null){
            Node right = util(node.right);
            for(; right.left!=null; right = right.left);
            right.left  = node;
            node.right = right;
        }
        return node;
    }
    static Node conversion(Node node){
        if(node == null)
            return node;
        node = util(node);
        while(node.left!=null)
            node = node.left;
        return node;
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.right;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        
        root = conversion(root);
        print(root);
    }
}
