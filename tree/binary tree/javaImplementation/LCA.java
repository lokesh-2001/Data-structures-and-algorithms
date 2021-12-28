package javaImplementation;
// Find LCA in a Binary tree
// least common ancestor
import java.util.HashMap;
import java.util.Map;
public class LCA {
    static class Node{
        int data;
        Node left, right,parent;
        Node(int d){
            data = d;
            left = right = parent= null;
        }
    }
    // Node root,n1,n2,lca;
    static Node insert(Node node, int d){
        if(node == null)
            return new Node(d);
        if(d < node.data){
            node.left = insert(node.left,d);
            node.left.parent = node;
        }
        if(d > node.data){
            node.right = insert(node.right,d);
            node.right.parent = node;
        }
        return node;
    }
    static Node lca(Node n1,Node n2){
        Map<Node,Boolean> ances = new HashMap<Node,Boolean>();
        while(n1!=null){
            ances.put(n1, Boolean.TRUE);
            n1 = n1.parent;
        }   
        while(n2!=null){
            if(ances.containsKey(n2))
                return n2;
            n2=n2.parent;
        }
        return null;
    }
    public static void main(String[] args) {
        
        Node root = new Node(20);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 10);
        root = insert(root, 14);
  
        Node n1 = root.left.right.left;
        Node n2 = root.left;
        Node lca = lca(n1, n2);
  
        System.out.println("LCA of " + n1.data + " and " + n2.data
                + " is " + lca.data);  
    }
}
