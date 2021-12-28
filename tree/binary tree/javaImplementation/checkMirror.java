package javaImplementation;
// Check if 2 trees are mirror or not
public class checkMirror {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null; 
        }
    }
    static boolean check(Node a , Node b){
        if(a == null && b== null)
            return true;
        if(a == null || b == null)
            return false;
        return (a.data == b.data && check(a.left, b.right) && check(a.right, b.left) );
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);
 
        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);
        if(check(a,b))
            System.out.println("True");
        else
            System.out.println("False");

    }
}
