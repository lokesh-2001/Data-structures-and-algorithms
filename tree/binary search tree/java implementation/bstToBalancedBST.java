// convert a normal bst to balanced bst
import java.util.*;
public class bstToBalancedBST {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null; 
        }
    }
    Node root = null;
    static void storeNodes(Node node, Vector<Node> nodes){
        if(node == null)
            return;
        storeNodes(node.left, nodes);
        nodes.add(node);
        storeNodes(node.right, nodes);
    }
    static Node base(Node node){
        Vector<Node> nodes = new Vector<Node>();
        storeNodes(node, nodes);
        int n = nodes.size();
        return util(nodes, 0, n-1);
    }
    static Node util(Vector<Node> nodes, int start ,int end){
        if(start>end)
            return null;
        int mid =  (start+end)/2;
        Node node = nodes.get(mid);
        node.left = util(nodes, start, mid-1);
        node.right = util(nodes, mid+1, end);
        return node;
    }
    static void preorder(Node node){
        if(node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.left.left = new Node(6);
        root.left.left.left.left = new Node(5);
 
        root = base(root);
        System.out.println("Preorder traversal of balanced BST is :");
        preorder(root);
    }
}
