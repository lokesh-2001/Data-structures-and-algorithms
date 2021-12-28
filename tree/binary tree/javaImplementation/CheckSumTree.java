package javaImplementation;
// check if a binary tree is sum tree
public class CheckSumTree{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static int sum(Node node){
        if(node == null)
            return 0;
        return( sum(node.left) + node.data +sum(node.right) );
    }
    static boolean check(Node node){
        int leftSum,rightSum;
        if(node == null || (node.left == null && node.right == null))
            return true;
        leftSum = sum(node.left);
        rightSum = sum(node.right);
        if(node.data == leftSum + rightSum &&
        check(node.left) && check(node.right))
            return true;
        return false;
    }
    public static void main(String[] args) {
        Node root=new Node(26);
        root.left=new Node(10);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(6);
        root.right.right=new Node(3);
        if(check(root))
            System.out.println("is sum tree");
        else
            System.out.println("not sum tree");
        
    }
}
