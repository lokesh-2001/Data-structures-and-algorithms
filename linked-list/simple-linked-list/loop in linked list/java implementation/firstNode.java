public class firstNode{
    static class Node{
        int key;
        Node next;
    }
    static Node newNode(int key){
        Node temp = new Node();
        temp.key =key;
        temp.next = null;
        return temp;
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.key + " ");
            node = node.next;
        }
        System.out.println();
    }
    static Node first(Node head){
        Node temp = new Node();
        while(head!=null){
            if(head.next ==null)
                return null;
           if(head.next ==  temp)
                break;
            Node nex = head.next;
            head.next = temp;
            head = nex;
        }
        return head;
    }
    public static void main(String[] args) {
        Node head = newNode(50);
        head.next = newNode(20);
        head.next.next = newNode(15);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(10);

        head.next.next.next.next.next = head.next.next;
        Node res = new Node();
        res = first(head);
        if(res == null)
            System.out.println("No loop detected");
        else
            System.out.println("starting node: " + res.key);
    }
    
}