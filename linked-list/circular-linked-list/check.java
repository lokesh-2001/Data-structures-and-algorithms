public class check {
    static class Node{
        int data;
        Node next;
    }
    static Node newNode(int d){
        Node n = new Node();
        n.data = d;
        n.next = null;
        return n;
    }
    static boolean CheckCircular(Node head){
        if(head == null)    
            return true;
        Node node = head.next;
        while(node!=null && node!=head)
            node = node.next;
        return(node == head);
    }
    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(2); 
        head.next.next = newNode(3); 
        head.next.next.next = newNode(4); 
        head.next.next.next.next = newNode(5);
        System.out.println(CheckCircular(head) ? "Yes" : "No");
        head.next.next.next.next.next = head;
        System.out.println(CheckCircular(head) ? "Yes" : "No");

    }
}
