package javaImplementation;

public class BoundaryTraversal {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right =null;
        }
    }
    static void printLeaves(Node root){
        if(root == null)
            return;
        printLeaves(root.left);
        if(root.left == null && root.right == null)
            System.out.print(root.data + " ");
        printLeaves(root.right);
    }
    static void printLeft(Node root){
        if(root == null)
            return;
        if(root.left!=null){
            System.out.print( root.data+ " ");
            printLeft(root.left);
        }
        else if(root.right!=null){
            System.out.print( root.data+ " ");
            printLeft(root.right);
        }
    }
    static void printRight(Node root){
        if(root == null)
            return;
        if(root.right!=null){
            printLeft(root.right);
            System.out.print( root.data+ " ");
        }
        if(root.left!=null){
            printLeft(root.left);
            System.out.print( root.data+ " ");
        }
    }
    static void boundary(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        printLeft(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRight(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        boundary(root); 
    }
}
