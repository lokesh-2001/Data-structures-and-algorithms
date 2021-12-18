// add "1" represented to the number represented by linked list
public class Add1ToNo {
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null; 
        }
    }
    static Node reverse(Node head){
        Node curr = head, prev=null, next=null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static Node AddOne(Node node){
        node = reverse(node);
        node = AddOneUtil(node);
        return reverse(node);
    }
    static Node AddOneUtil(Node node){
        Node res = node;
        Node temp = null;
        int carry=1,sum=0;
        while(node!=null){
            sum = carry + node.data;
            carry = (sum>=10) ? 1 : 0;
            sum = sum%10;
            node.data = sum;
            temp = node;
            node = node.next; 
        }
        if(carry>0)
            node.next = new Node(carry);
        return res;
    }
    static void print(Node node){
        while(node!=null){
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next  = new Node(3);
        System.out.println("LL is : ");
        print(head);
        head = AddOne(head);
        System.out.println();
        System.out.println("LL is : ");
        print(head);

    }
}
