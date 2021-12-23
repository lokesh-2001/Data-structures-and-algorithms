// 5 -> 10 -> 19 -> 28
// |    |     |     |
// V    V     V     V
// 7    20    22    35
// |          |     |
// V          V     V
// 8          50    40
// |                |
// V                V
// 30               45

// flat the linked list to this
// 5->7->8->10->19->20->22->28->30->35->40->45->50. 
public class FlattenALinkedList {
    static class Node{
        int data;
        Node next, down;
        Node(int d){
            data = d;
            next = down = null;
        }
    }
    // merge two sorted linked lists
    static Node merge(Node a , Node b){
        if(a == null)
            return b;
        if(b == null)
            return a;
        Node newHead;
        if(a.data<b.data){
            newHead  = a;
            newHead.down = merge(a.down,b);
        }
        else{
            newHead  = b;
            newHead.down = merge(a,b.down);            
        }
        newHead.next = null;
        return newHead;
    }
    static Node flatten(Node node){
        if(node == null || node.next==null)
            return node;
        node.next = flatten(node.next);
        node = merge(node, node.next);
        return node;
    }
    static Node push(Node head, int d){
        Node temp = new Node(d);
        temp.down = head;
        head = temp;
        return temp;
    }
    static void print(Node temp){
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(30);
        // head = push(head, 30);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 5);
        head.next = push(head.next, 20);
        head.next = push(head.next, 10);
        head.next.next = push(head.next.next, 50);
        head.next.next = push(head.next.next, 22);
        head.next.next = push(head.next.next, 19);
        head.next.next.next = push(head.next.next.next, 45);
        head.next.next.next = push(head.next.next.next, 40);
        head.next.next.next = push(head.next.next.next, 35);
        head.next.next.next = push(head.next.next.next, 20);
  
        // flatten the list
        head = flatten(head);
  
        print(head);
    }

}
