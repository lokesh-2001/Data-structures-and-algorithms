// find size of largest bst in a binary tree 
public class largestBST {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data =d;
            left = right= null;
        } 
    }
    static class info{
        int size;
        int max;
        int min;
        boolean isBST;
        info(){};
        info(int n, int ma, int mi, boolean is){
            size = n;
            max = ma;
            min = mi;
            isBST = is; 
        }
    }
    public static void main(String[] args) {
    Node node1 = new Node(60);
    node1.left = new Node(65);
    node1.right = new Node(70);
    node1.left.left = new Node(50);
    System.out.print("Size of the largest BST is " + size(node1) + "\n");
    }
    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    static info largest(Node node){
        if(node == null)
            return new info(0,MIN,MAX,true);
        if(node.left == null && node.right == null)
            return new info(1,node.data,node.data,true);
        info left = largest(node.left);
        info right = largest(node.right);
        
        info result = new info();
        if(left.isBST && right.isBST && left.max<node.data && right.min > node.data){
            result.min = Math.min(Math.min(left.min,right.min),node.data);
            result.max = Math.max(Math.max(left.max,right.max),node.data);
            result.size = left.size + right.size + 1;
            result.isBST = true;
            return result;
        }        
        result.size = Math.max(left.size,right.size);
        result.isBST = false;
        return result;
    }
    static int size(Node root){
        return largest(root).size;
    }
}
