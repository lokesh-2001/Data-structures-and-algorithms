public class QuickSort {
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
    static Node partition(Node startNode, Node endNode ){
        if(startNode == endNode || startNode == null || endNode == null)
            return startNode;
        Node pivot_prev = startNode;
        Node curr = startNode;
        int pivot = endNode.data;
        while(startNode!=endNode){
            if(startNode.data<pivot){
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = startNode.data;
                startNode.data = temp;
                curr = curr.next;
            }
            startNode = startNode.next;
        }
        int temp = curr.data;
        curr.data = pivot;
        endNode.data = temp;

        return pivot_prev;
    }
    static void sort(Node left,Node right){
        if(left == null || right == left || left == right.next)
            return;
        Node pivotPrev = partition(left,right);
        sort(left,pivotPrev);
        if (pivotPrev != null && pivotPrev == left)
        sort(pivotPrev.next, right);
        else if(pivotPrev != null && pivotPrev.next != null)
            sort(pivotPrev.next.next,right); 
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
        sort(head,n);
        print(head);

    }

}
