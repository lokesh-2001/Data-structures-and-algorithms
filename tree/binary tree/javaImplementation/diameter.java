package javaImplementation;

public class diameter {
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
    static int dia(Node root){
        if(root == null)
            return 0;
        int lH = height(root.left);
        int rH = height(root.right);
        int lD = dia(root.left);
        int rD = dia(root.right);

        return Math.max((lH+rH+1), Math.max(lD,rD));
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(dia(root));
    }
}
