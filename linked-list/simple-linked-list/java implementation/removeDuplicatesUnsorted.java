// remove duplicates from an unsorted linked list
import java.util.HashSet;
public class removeDuplicatesUnsorted {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    static void RemoveDuplicates(Node node){
        HashSet<Integer> hs = new HashSet<>();
        Node curr =node;
        Node prev = null;
        while(curr!=null){
            int val = curr.data;
            if(hs.contains(val))
                prev.next = curr.next;
            else{
                hs.add(val);
                prev = curr;
            }
            curr = curr.next;
        }
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(23); 
        head.next.next = new Node(85); 
        head.next.next.next = new Node(274); 
        head.next.next.next.next = new Node(23);
        head.next.next.next.next.next = new Node(29);
        head.next.next.next.next.next.next = new Node(23);
        System.out.println("ll before removal");
        print(head);
        System.out.println();
        System.out.println("ll after removal");
        RemoveDuplicates(head);
        print(head);

    }

}
