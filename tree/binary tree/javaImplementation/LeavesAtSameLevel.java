package javaImplementation;
public class LeavesAtSameLevel{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static class Leaf{
        int Level = 0; 
    }
    static boolean util(Node node, int level, Leaf l){
        if(node == null)
            return true;
        if(node.left == null && node.right == null){
            if (l.Level == 0){
                l.Level = level;
                return true;
            }
        return(level == l.Level);
        }
        return util(node.left, level+1, l) && util(node.right, level+1, l);
    }
    static boolean check(Node node){
        int level = 0;
        Leaf l  = new Leaf();
        return util(node, level, l);
    }
    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(1);   
        if(check(root))
            System.out.println("true");
        else
            System.out.println("false");

    }
}