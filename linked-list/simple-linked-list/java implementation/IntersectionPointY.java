// write a function to get the intersection point of two linked lists
import java.util.*;
public class IntersectionPointY {
    static class Node{
        int data;
        Node next;
    }
    static Node newNode(int d){
        Node n =  new Node();
        n.data = d;
        n.next = null;
        return n;
    }
    static Node Intersect(Node head1, Node head2){
        HashSet<Integer> hs = new HashSet<Integer>();
        while(head1!=null){
            hs.add(head1.data);
            head1 = head1.next;
        }
        while(head2!=null){
            if(hs.contains(head2.data)){
                return head2;
                // System.out.print(head2.data + " ");
            }
            head2=head2.next;
        }
        return null;
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    } 

    public static void main(String[] args) {
        Node head1 = newNode(7);
        head1.next = newNode(5);
        head1.next.next = newNode(9);
        head1.next.next.next = newNode(4);
        head1.next.next.next.next = newNode(6);

        System.out.println("List 1: ");
        print(head1);
        System.out.println();
        Node head2 = newNode(8);
        head2.next = newNode(9);
        head2.next.next = newNode(9);
        head2.next.next.next = newNode(4);
        head2.next.next.next.next = newNode(6);
        System.out.println();

        System.out.println("List 2: ");
        print(head2);
        System.out.println();
        System.out.print("Intersection Node: ");
        Node intersect = new Node();
        intersect = Intersect(head1,head2);
        System.out.print(intersect);
    }

}
