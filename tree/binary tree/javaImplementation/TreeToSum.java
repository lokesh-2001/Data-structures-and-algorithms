package javaImplementation;

public class TreeToSum {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right =null;
        }
    }
    static int convert(Node node){
        if(node == null)
            return 0;
        int old_val = node.data;
        node.data = convert(node.left) + convert(node.right);
        
        return node.data + old_val;
    }
    static void inorder(Node node){
        if(node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);
        convert(root);
        inorder(root);
    }
}
