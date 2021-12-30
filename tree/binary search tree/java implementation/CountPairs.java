// Count pairs from two BSTs whose sum is equal to a given value x
import java.util.Stack;
public class CountPairs{
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data = d;
            left = right = null;
        }
    }
    static int count(Node node1, Node node2, int x){
        if(node1==null || node2==null)
            return 0;
        Stack<Node>s1 = new Stack<>();
        Stack<Node>s2 = new Stack<>();
        Node top1,top2;
        int count = 0;
        while(true){
            while(node1!=null){
                s1.push(node1);
                node1 = node1.left;
            }
            while(node2!=null){
                s2.push(node2);
                node2 = node2.right;
            }
            if(s1.empty() || s2.empty())
               break;
            top1 = s1.peek();
            top2 = s2.peek();
            
            if(top1.data + top2.data == x){
                count++;
                s1.pop();
                s2.pop();
                node1 = top1.right;
                node2 = top2.left;
            }
            else if(top1.data + top2.data < x){
                s1.pop();
                node1 = top1.right;
            }
            else{
                s2.pop();
                node2 = top2.left;                
            }                
        }
        return count;
    }
    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);        
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);
        System.out.println(count(root1, root2, 16));
    }
}