package javaImplementation;
import java.util.*;
public class topView {
    static class Node{
        int data;
        Node left,right;
        Node (int d){
            data  = d;
            left = right = null;
        }
    }
    static class pair{
        int first,second;
        pair(){}
        pair(int i, int j){
            first = i;
            second= j;
        }
    }
    // map to store the node value and its level with respect to the 
    // vertical distance from root
    static TreeMap<Integer,pair> m = new TreeMap<>();
    static void fillMap(Node root, int d, int l){
        if(root==null)
            return ;
        if(m.get(d) == null )
            m.put(d,new pair(root.data,l));
        else if(m.get(d).second > l)
            m.put(d,new pair(root.data,l));
        fillMap(root.left,d-1,l+1);
        fillMap(root.right,d+1,l-1);
    } 
    static void topview(Node root){
        fillMap(root,0,0);
        for(Map.Entry<Integer,pair> entry: m.entrySet())
            System.out.print(entry.getValue().first + " ");
    }   
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        topview(root);

    }
}
