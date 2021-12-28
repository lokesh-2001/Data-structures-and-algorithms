package javaImplementation;
import java.util.Queue;
import java.util.LinkedList;
public class LevelOrderTraversal{
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d ;
            left = right = null; 
        }
    }
    static void levelOrder(Node head){
        Queue<Node> q = new LinkedList<Node>();
        q.add(head);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.data + "  ");
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        levelOrder(root);
    }
}