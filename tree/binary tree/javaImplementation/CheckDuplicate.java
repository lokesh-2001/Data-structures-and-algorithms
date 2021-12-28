package javaImplementation;
// Check if a Binary Tree contains duplicate subtrees of size 2 or more
import java.util.HashSet;
public class CheckDuplicate {
    static class Node{
        int data;
        Node left, right ;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static char marker  = '$';
    static String util(Node node,HashSet<String> hs){
        String s = "";
        if(node == null)
            return s + marker;
        String lstr = util(node.left, hs);
        if(lstr.equals(s))
            return s;
        String rstr = util(node.right, hs);
        if(rstr.equals(s))
                return s;
        
        s  = s + node.data + lstr + rstr;

        if(s.length() > 3 && hs.contains(s))
            return "";
        
        hs.add(s);
        return s;
    }
    static String check(Node root){
        HashSet<String> hs = new HashSet<>();
        return util(root, hs);
    }
    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left= new Node('D');
        if(check(root).equals(""))
            System.out.println("True");
        else
            System.out.println("False"); 

    }
}
