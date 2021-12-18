// Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists.
import java.util.*;
public class IntersectionOfSorted {
    static class Node{
        int data;
        Node next;
    }
    static Node newNode(int d){
        Node n = new Node();
        n.data = d;
        n.next =  null;
        return n;
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    } 
    static void append(Node head, int d){
        Node n = newNode(d);
        if(head==null){
            head = newNode(d);
            return;
        }
        n.next = null;
        Node last = head;
        while(last.next!=null)
            last = last.next;
        last.next = n;
    }
    static void intersection(Node head1, Node head2){
        HashSet<Integer> hs = new HashSet<Integer>();
        while(head1!=null){
            hs.add(head1.data);
            head1 = head1.next;
        }
        while(head2!=null){
            if(hs.contains(head2.data)){
                System.out.print(head2.data + " ");
            }
            head2=head2.next;
        }
    }
    static Node deleteFront(Node head){
        if(head == null)
            return null;
        head = head.next;
        return head;
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
        head2.next.next = newNode(6);
        head2.next.next.next = newNode(4);
        System.out.println();

        System.out.println("List 2: ");
        print(head2);
        System.out.println();
        System.out.println("Resultant List: ");
        intersection(head1,head2);
    }
}
