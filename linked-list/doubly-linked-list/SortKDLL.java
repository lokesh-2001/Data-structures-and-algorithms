// sort a k sorted doubly linked list
import java.util.*;
public class SortKDLL {
    static class Node{
        int data;
        Node next,prev;
        Node(int d){
            data = d;
            next = prev = null;
        }
    }
    // static Node head;
    static class compareNode implements Comparator<Node>{
        public int compare(Node n1,Node n2){
            return n1.data - n2.data;
        }
    }
    static Node kSort(Node head, int k){
        if(head == null)
            return head;
        PriorityQueue<Node> pq =new PriorityQueue<Node>(new compareNode());
        Node newHead  = null, last = null;
        for(int i=0;head!=null && i<=k;i++){
            pq.add(head);
            head = head.next;
        }
        while(!pq.isEmpty()){
            if(newHead==null){
                newHead = pq.peek();
                newHead.prev = null;
                last = newHead;
            }
            else{
                last.next = pq.peek();
                pq.peek().prev = last;
                last = pq.peek();
            }
            pq.poll();
            if(head!=null){
                pq.add(head);
                head = head.next;
            }
        }
        last.next = null;
        return newHead;
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
    public static void main(String[] args) {
        Node head = new Node(8);
        head = push(head, 56);
        head = push(head, 12);
        head = push(head, 2);
        head = push(head, 6);
        head = push(head, 3);
        System.out.println("Before Sorting: ");
        print(head);
        System.out.println();
        System.out.println();
        head = kSort(head, 2);
        System.out.println("Before Sorting: ");
        print(head);
    }

}
