package javaImplementation;
// Maximum Sum of nodes in Binary tree such that no two are adjacent 
// Return a pair for each node in the binary tree such that the first 
// of the pair indicates maximum sum when the data of a node is included 
// and the second indicates maximum sum when the data of a particular node is not included. 
public class MaxSum {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static class Pair{
        int first,second;
        Pair(int fi,int se){
            first = fi;second =se;
        }
    }
    static Pair util(Node node){
        if(node == null){
            Pair sum =  new Pair(0,0);
            return sum;
        }
        Pair suml = util(node.left);
        Pair sumr = util(node.right);
        Pair sum = new Pair(0,0);

        sum.first = suml.second + sumr.second + node.data;
        sum.second = Math.max(suml.first,suml.second) + Math.max(sumr.first,sumr.second);
        return sum;
    } 
    static int base(Node node){
        Pair res = util(node);
        return Math.max(res.first, res.first);
    }
    public static void main(String[] args) {
        Node root= new Node(10); 
        root.left= new Node(1); 
        root.left.left= new Node(2); 
        root.left.left.left= new Node(1); 
        root.left.right= new Node(3); 
        root.left.right.left= new Node(4); 
        root.left.right.right= new Node(5); 
        System.out.print(base(root));  
    }

}

