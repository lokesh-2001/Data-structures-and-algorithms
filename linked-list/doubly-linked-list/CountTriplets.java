public class CountTriplets {
    static class Node{
        int data;
        Node prev,next;
    }
    static Node newNode(int d){
        Node n =  new Node();
        n.data = d;
        n.next = n.prev = null;
        return n;
    }
    static int countPairs(Node fi,Node se, int val){
        int count =0;
        while(fi!=null && se!=null && fi!=se && se.next!=fi){
            if(fi.data + se.data == val){
                count ++;
                fi = fi.next;
                se = se.prev;
            }
            else if(fi.data + se.data > val)
                se = se.prev;
            else
                fi = fi.next;
        }
        return count;
    }
    static Node insert(Node head, int data){
        Node temp = new Node();
  
        // put in the data
        temp.data = data;
        temp.next = temp.prev = null;
      
        if ((head) == null)
            (head) = temp;
        else {
            temp.next = head;
            (head).prev = temp;
            (head) = temp;
        }
        return head;
    
    }
    static int countTriplets(Node head, int x){
        if(head ==  null)
            return 0;
        Node curr, first, last;
        int count = 0;
        last = head;
        while(last.next!=null)
            last = last.next;
        for(curr = head; curr!=null;curr = curr.next){
            first = curr.next;
            count += countPairs(first, last, x-curr.data);
        }
        return count;
    }
    public static void main(String[] args) {
        Node head = null;
  
        // insert values in sorted order
        head = insert(head, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);
      
        int x = 17;
      
        System.out.print("Count = "
             + countTriplets(head, x));
       
    }
}
