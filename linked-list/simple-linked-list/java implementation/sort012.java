// sort a linked list of 0s 1s and 2s
public class sort012{
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
    static void print(Node temp){
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    static void sort(Node head){
        int count[] = {0,0,0};
        Node temp = head;
        while(temp!=null){
            count[temp.data]++;
            temp = temp.next;
        }
        temp = head;
        int i = 0 ;
        while(temp!=null){
            if(count[i] == 0 )
                i++;
            else{
                temp.data = i;
                --count[i];
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(2);
        System.out.println("Linked List before sorting");
        print(head);
        sort(head);
        System.out.println();
        System.out.println("Linked List after sorting");
        print(head);
    }
}