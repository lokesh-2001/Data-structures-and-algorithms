package javaImplementation;

import java.util.Vector;

// Print all k-sum paths in a binary tree
public class SumKPaths {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static void print(Vector<Integer>v, int i){
        for(int j = i;j<v.size();j++)
            System.out.print(v.get(j) + " ");
        System.out.println();
    }
    static Vector<Integer> path = new Vector<Integer>();
    static void util(Node root, int k){
        if(root == null)
            return;
        path.add(root.data);
        util(root.left, k);
        util(root.right, k);
        int f = 0;
        for(int j = path.size()-1;j>=0;j--){
            f+=path.get(j);
            if(f==k)
                print(path, j);
        }
        path.remove(path.size()-1);
    }
    static void base(Node node, int k){
        path  = new Vector<Integer>();
        util(node, k);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);
        base(root,5);
    }
}
