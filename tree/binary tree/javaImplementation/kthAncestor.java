package javaImplementation;
// Kth Ancestor of node in a Binary tree
public class kthAncestor {
    static class Node{
        int data;
        Node left, right ;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static int k = 1;
    static boolean ancestor(Node node, int item){
        if(node == null)
            return false;
        if(node.data == item){
            k = k-1;
            return true;
        }
        boolean flag = ancestor(node.left, item);
        if(flag){
            if(k==0){
                System.out.print("[ " + node.data + " ] ");
                return false;
            }
            k=k-1;
            return true;
        }
        boolean flag2 = ancestor(node.right, item);
        if(flag2){
            if(k==0){
                System.out.print("[ " + node.data + " ] ");
                return false;
            }
            k=k-1;
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(4);
        root.left.right = new Node(7);
        root.left.left = new Node(3);
        root.left.right.left = new Node(8);
        root.right = new Node(2);
        root.right.right = new Node(6);
         
        int item = 3;
        int loc = k;
        boolean flag = ancestor(root, item);
         
        if (flag)
            System.out.println("Ancestor doesn't exist");
        else
            System.out.println("is the " + (loc) +
                               "th ancestor of [" +
                               (item) + "]");   
    }
}
