package javaImplementation;

public class Height {
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d ;
            left = right = null; 
        }
    }
    static int height(Node root){
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(left>right)
            return left+1;
        return right+1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(height(root));
    }
}
