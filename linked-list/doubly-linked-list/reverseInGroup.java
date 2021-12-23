import java.util.*;
public class reverseInGroup {
    static class Node{
        int data;
        Node next, prev;
        Node(int d){
            data = d;
            next = prev = null; 
        }
    }
    static Node push(Node head, int d){
        Node temp = new Node(d);
        temp.prev = null;
        temp.next = head;
        if(head!=null)
            head.prev = temp;
        head = temp;
        return temp;
    }
    static void print(Node temp){
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static Node reverseByk(Node head, int k){
        if(head  == null)
            return head;
        head.prev = null;
        Node temp ;
        Node curr = head;
        Node newHead = null;
        int count = 0 ;
        while(curr!=null && count<k){
            newHead = curr;
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
            count++;
        }
        if(count >= k){
            Node rest = reverseByk(curr, k);
            head.next = rest;
            if(rest!=null)
                rest.prev = head;
        }
        return newHead;
    }
    public static void main(String[] args) {
        Node head = null;
        for(int i=1;i<=10;i++)
            head = push(head,i);
        System.out.println("Before reversing in groups: ");
        System.out.println();
        print(head);
        head = reverseByk(head,4);
        System.out.println();
        System.out.println("After reversing in groups: ");
        System.out.println();
        print(head);

    }



}
