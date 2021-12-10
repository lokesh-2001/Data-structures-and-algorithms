import java.util.*;
public class BTtoBST {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    static int index;
    static void inorder(Node node, int inorder[]){
        if(node == null)
            return;
        inorder(node.left,inorder);
        inorder[index] = node.data;
        index++;
        inorder(node.right, inorder);
    }
    static int count(Node root){
        if(root == null)
            return 0;
            return count(root.left) + count(root.right) + 1;    
    }
    static void arrayToBt(int [] arr, Node root){
        if(root == null)
            return ;
        arrayToBt(arr, root.left);
        root.data = arr[index];
        index++;
        arrayToBt(arr, root.right);
    }
    static void BTtoBST(Node root){
        if(root==null)
            return;
        int n = count(root);
        int arr[] = new int[n];
        inorder(root,arr);
        Arrays.sort(arr);
        index = 0;
        arrayToBt(arr, root);
    }
    static void print(Node node){
        if(node==null)
            return;
        print(node.left);
        System.out.print(node.data + " ");
        print(node.right);

    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);
        BTtoBST(root);
        print(root);
    }
}
