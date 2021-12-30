// Populate Inorder successor of all nodes
// The next pointer for every node should be set to point to inorder successor.
import java.util.ArrayList;
public class populateinorderSuccessor {
    static class Node{
        int data;
        Node left,right,next;
        Node(int d){
            data = d;
            left = right = next = null;
        }
    }
    static void inorder(Node node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }   
    }
    
    static void populate(Node root){
        ArrayList<Node> list = new ArrayList<>();
        for(int i =0 ;i<list.size();i++){
            if(i!=list.size()-1)
                list.get(i).next = list.get(i+1);
            else
                list.get(i).next = null;
        }
        Node ptr = root.left.left;
        while(ptr!=null){
            int print  = ptr.next !=null ? ptr.next.data : -1;
            System.out.println("Next of" + ptr.data + " is : "+ print);
            ptr = ptr.next;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
         
        //function calls
        inorder(root);
        populate(root);
    }
  
}
