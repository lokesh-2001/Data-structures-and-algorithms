public class MoveLastToFront {
    static class Node{
        int data;
        Node next;
        Node (int d){
            data = d;
            next = null;
        }
    } 
    static Node moveLast(Node head){
        if(head == null || head.next == null)
            return head;
        Node secondLast =null;
        Node last = head;
        while(last.next!=null){
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
        last.next = head;
        head = last;
        return head;
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
        head.next = new Node(85); 
        head.next.next = new Node(274); 
        head.next.next.next = new Node(29);
        head.next.next.next.next = new Node(23);
        System.out.println("ll before moving last to front");
        print(head);
        System.out.println();
        System.out.println("ll after moving last to front");
       head =  moveLast(head);
        print(head);

    }

}
