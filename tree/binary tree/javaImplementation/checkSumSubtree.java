package javaImplementation;
// Find Largest subtree sum in a tree
public class checkSumSubtree{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static int util(Node node, int ans){
        if(node == null)
            return 0;
        int currSum = node.data + util(node.left, ans) + util(node.right, ans);
        ans = Math.max(ans, currSum);
        return ans;
    }
    static int base(Node node){
        if(node == null)
            return 0;
        int ans = Integer.MIN_VALUE;
        ans = util(node, ans);
        return ans;
    }
    public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(-2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(-6);
    root.right.right = new Node(2);
 
    System.out.println(base(root));
    }

}