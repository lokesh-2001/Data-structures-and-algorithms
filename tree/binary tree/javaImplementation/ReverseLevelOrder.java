package javaImplementation;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
public class ReverseLevelOrder{
    static class Node{
        int data;
        Node left, right;
        Node(int d){
            data = d ;
            left = right = null; 
        }
    }
    static void ReverseLevel(Node head){
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        q.add(head);

        while(!q.isEmpty()){
            head = q.peek();
            q.remove();
            s.push(head);
            if(head.right!=null)
               q.add(head.right);
            if(head.left!=null)
                q.add(head.left);
        }
        while(!s.empty()){
            head = s.peek();
            System.out.print(head.data + "  ");
            s.pop();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        ReverseLevel(root);
    }
}