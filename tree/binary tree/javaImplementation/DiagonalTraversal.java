package javaImplementation;

// diagonal traversal of a binary tree
// every node will help to generate the next diagonal. 
// push the element in the queue only when its left exits
// process the node and move to its right
import java.util.*;
public class DiagonalTraversal {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    } 
    static class TNode{
        Node node;
        int level;
        TNode(Node n, int l){
            node = n;
            level = l;
        }
    }
    static void diagonalTraversal(Node root){
        if(root == null)
            return;
        TreeMap<Integer, List<Integer>> tm = new TreeMap<Integer,List<Integer>>();
        Queue<TNode> q = new LinkedList<TNode>();
        q.add(new TNode(root,0));
        while(!q.isEmpty()){
            TNode curr = q.poll();
            tm.putIfAbsent(curr.level, new ArrayList<>());
            tm.get(curr.level).add(curr.node.data);
            if(curr.node.left!=null)
                q.add(new TNode(curr.node.left, curr.level+1));
            if(curr.node.right!=null)
                q.add(new TNode(curr.node.right, curr.level));
        } 
        for(Map.Entry<Integer,List<Integer>> entry:tm.entrySet()){
            int k = entry.getKey();
            List<Integer> l = tm.get(k);
            for(int i =0;i<l.size();i++)
                System.out.print(l.get(i) + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        diagonalTraversal(root);
    }
}
