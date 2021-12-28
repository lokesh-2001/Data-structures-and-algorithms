package javaImplementation;

import java.util.*;

public class zigZagTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Vector<Integer> zigzag(Node root) {
        Deque<Node> q = new LinkedList<Node>();
        Vector<Integer> v = new Vector<Integer>();
        q.add(root);
        v.add(root.data);
        Node temp = null;
        int l = 1;
        while (q.size() > 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                if (l % 2 == 0) {
                    temp = q.peekLast();
                    q.pollLast();
                } else {
                    temp = q.peekFirst();
                    q.pollFirst();
                }
                if (l % 2 != 0) {
                    if (temp.right != null) {
                        q.add(temp.right);
                        v.add(temp.right.data);
                    }
                    if (temp.left != null) {
                        q.add(temp.left);
                        v.add(temp.left.data);
                    }
                } else {
                    if (temp.left != null) {
                        q.offerFirst(temp.left);
                        v.add(temp.left.data);
                    }
                    if (temp.right != null) {
                        q.offerFirst(temp.right);
                        v.add(temp.right.data);
                    }
                }
            }
            l++;
        }
        return v;
    }
    public static void main(String[] args) {
        Vector<Integer> v;
        
        // create tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        System.out.println("ZigZag Order traversal of binary tree is");
      
        v = zigzag(root);
      
        for (int i = 0; i < v.size();i++) 
            System.out.print(v.get(i) + " ");
        
    }
}

