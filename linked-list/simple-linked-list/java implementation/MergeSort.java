public class MergeSort {
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
    static Node middle(Node head){
        if(head==null)
            return head;
        Node temp1=head,temp2=head;
        while(temp2.next!=null && temp2.next.next!=null){
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        return temp1;
    }
    static Node sortedMerge(Node temp1,Node temp2){
        Node result  = null;
        if(temp1==null)
            return temp2;
        if(temp2==null)
            return temp1;
        if(temp1.data<=temp2.data){
            result = temp1;
            result.next = sortedMerge(temp1.next, temp2);
        }
        else{
            result = temp2;
            result.next = sortedMerge(temp1, temp2.next);
            
        }
        return result;
    }
    static Node sort(Node head){
        if(head == null || head.next ==null)
            return head;
        Node middle = middle(head);
        Node nextMiddle = middle.next;
        middle.next = null;
        Node left = sort(head);
        Node right = sort(nextMiddle);
        Node merge =  sortedMerge(left,right);
        return merge;
    }
    public static void main(String[] args) {
        Node head = newNode(90);
        head.next = newNode(34);
        head.next.next = newNode(45);
        head.next.next.next = newNode(20);
        head.next.next.next.next = newNode(74);
        Node n =  head;
        while(n.next!=null)
            n = n.next;
        System.out.println("Linked list: ");
        print(head);
        System.out.println();
        System.out.println("Linked list after sorting: ");
        head = sort(head);
        print(head);

    }

}
