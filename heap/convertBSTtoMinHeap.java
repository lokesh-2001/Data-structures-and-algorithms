import java.util.ArrayList;
// Create an array arr[] of size n, where n is the number of nodes in the given BST.
// Perform the inorder traversal of the BST and copy the node values in the arr[] in sorted order.
// Now perform the preorder traversal of the tree.
// While traversing the root during the preorder traversal, one by one copy the values from the array arr[] to the nodes.
public class convertBSTtoMinHeap {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    static void bstToArray(Node root, ArrayList<Integer> arr){
        if(root == null)
            return;
        bstToArray(root.left, arr);
        arr.add(root.data);
        bstToArray(root.right, arr);
    }
    static int index = 0;
    static void arrToHeap(Node root, ArrayList<Integer>arr){
        if(root == null)
            return;
        root.data = arr.get(index++);
        arrToHeap(root.left,arr);
        arrToHeap(root.right,arr);
    }
    static void convert(Node root){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        bstToArray(root, arr);
        arrToHeap(root, arr);
    }
    public static void main(String[] args) {
        Node root = new Node(4);
    root.left = new Node(2);
    root.right = new Node(6);
    root.left.left = new Node(1);
    root.left.right = new Node(3);
    root.right.left = new Node(5);
    root.right.right = new Node(7);
     
    System.out.print("Preorder Traversal Before Conversion :" +"\n");
    preorder(root);
    convert(root);
     
    System.out.print("\nPreorder Traversal After Conversion :" +"\n");
    preorder(root);

    }
}