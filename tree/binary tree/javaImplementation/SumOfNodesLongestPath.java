package javaImplementation;
// Sum of Nodes on the Longest path from root to leaf node 
public class SumOfNodesLongestPath {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null; 
        }
    }
    static int maxLen;
    static int maxSum;

    static int base(Node node){
        if(node == null)
            return 0;
        maxSum = Integer.MIN_VALUE;
        maxLen = 0;
        util(node,0,0);
        return maxSum;
    }
    static void util(Node root, int sum, int len){
        if(root == null){
            if(maxLen < len){
                maxLen = len;
                maxSum = sum;
            }
            else if(maxLen == len && maxSum < sum)
                maxSum = sum;
            return;
        }
        util(root.left, sum + root.data , len + 1);
        util(root.right, sum + root.data , len + 1);
    }
    public static void main(String[] args) {
        Node root = new Node(4);         
        root.left = new Node(2);         
        root.right = new Node(5);        
        root.left.left = new Node(7);    
        root.left.right = new Node(1);   
        root.right.left = new Node(2);   
        root.right.right = new Node(3);  
        root.left.right.left = new Node(6);
        
        System.out.println(base(root));
    }

}
