import java.util.*;
public class DetectLoop {
    Node head;
    static class Node{
        int data;
        Node next;
        Node (int d){
            data = d;
            next = null;
        }
    }
    static int detectLoop(Node node){
        Node slow = node, fast = node;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                removeLoop(slow,node);
                return 1;
            }
        }
        return 0;
    }
    static void removeLoop(Node loopNode,Node node){
        Node ptr1 = loopNode;
        Node ptr2 = loopNode;
        int k = 1;
        while(ptr1.next != ptr2){
            ptr1 = ptr1.next;
            k++;
        }
        ptr2 = node;
        for(int i=0;i<k;i++)
            ptr2 = ptr2.next;
        while(ptr2.next != ptr1)
            ptr2 = ptr2.next;
        ptr2.next = null;
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    static boolean removeLoop2(Node node){
        HashSet<Node> hs = new HashSet<Node>();
        Node prev = null;
        while(node != null){
            if(hs.contains(node)){
                prev.next = null;
                return true;
            }   
            else{
                hs.add(node);
                prev = node;
                node = node.next; 
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectLoop li = new DetectLoop();
        li.head = new Node(50);
        li.head.next = new Node(20);
        li.head.next.next = new Node(15);
        li.head.next.next.next = new Node(4);
        li.head.next.next.next.next = new Node(10);
 
        // Creating a loop for testing
        li.head.next.next.next.next.next = li.head.next.next;
        if(removeLoop2(li.head)){
            System.out.println("ll after removal of loop: ");
            print(li.head);    
        }
        // detectLoop(li.head);
        // System.out.println("Linked List after removing loop : ");
        // print(li.head);    
    }
}
