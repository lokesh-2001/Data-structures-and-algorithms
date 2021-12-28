package javaImplementation;
// Tree Isomorphism Problem
public class isomorphism {
    static class Node{
        int data;
        Node left, right ;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static boolean isomorphic(Node n1,Node n2){
        if(n1 == null && n2 == null)
            return true;
        if(n1 == null || n2 == null)
            return false;
        if(n1.data != n2.data)
            return false;
        return isomorphic(n1.left, n2.left) && isomorphic(n1.right, n2.right) || 
        isomorphic(n1.left, n2.right) && isomorphic(n1.right, n2.left);
    }
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.left.right.left = new Node(7);
        root1.left.right.right = new Node(8);
  
        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.left = new Node(4);
        root2.right.right = new Node(5);
        root2.left.right = new Node(6);
        root2.right.right.left = new Node(8);
        root2.right.right.right = new Node(7);
  
        if (isomorphic(root1, root2) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

