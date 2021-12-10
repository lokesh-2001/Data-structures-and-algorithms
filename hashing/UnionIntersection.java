// union and intersection of two linked lists

import java.util.HashMap;
import java.util.HashSet;

public class UnionIntersection {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

    }
    Node head;
    void print(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data + " " );
            temp = temp.next;    
        }
        System.out.println();
    }
    void push(int data){
        Node node  = new Node(data);
        node.next = head;
        head = node;
    }   
    void append(int data){
        if(this.head == null){
            Node node = new Node(data);
            this.head =  node;
            return;
        }
        Node n1 = this.head;
        Node n2 = new Node(data);
        while(n1.next!=null)
            n1=n1.next;
        n1.next = n2;
    }
    boolean isPresent(Node head, int data){
        Node t = head;
        while(t!=null){
            if(t.data == data)
                return true;
            t = t.next;
        } 
        return false;
    }

    UnionIntersection getIntersection(Node head1, Node head2){
        HashSet<Integer> hset =  new HashSet<>();
        Node n1 = head1;
        Node n2 = head2;
        UnionIntersection result = new UnionIntersection();
        while(n1!=null){
            if(hset.contains(n1.data)){
                hset.add(n1.data);
            }
            else
                hset.add(n1.data);
            n1 = n1.next;
        }        
        while (n2!=null) {
            if(hset.contains(n2.data))
                result.push(n2.data);
            n2 = n2.next;
        }
        return result;
    }

    UnionIntersection getUnion(Node head1, Node head2){
        HashMap<Integer, Integer> hmap =  new HashMap<>();
        Node n1 = head1;
        Node n2 = head2;
        UnionIntersection result = new UnionIntersection();
        while(n1!=null){
            if(hmap.containsKey(n1.data)){
                hmap.put(n1.data, hmap.get(n1.data)+1);
            }
            else
            hmap.put(n1.data ,1);
        n1 = n1.next;
        }        
        while (n1!=null) {
            if(hmap.containsKey(n2.data))
                hmap.put(n2.data, hmap.get(n2.data)+1);
            else
                hmap.put(n2.data,1);
            n2 = n2.next;
        }
        for(int a : hmap.keySet())
            result.append(a);
        return result;
    }
    public static void main(String[] args) {
        UnionIntersection ll1 =  new UnionIntersection();
        UnionIntersection ll2 =  new UnionIntersection();
        UnionIntersection union =  new UnionIntersection();
        UnionIntersection intersection =  new UnionIntersection();
        ll1.push(20);
        ll1.push(4);
        ll1.push(15);
        ll1.push(10);
        ll1.push(60);
        
        ll2.push(20);
        ll2.push(15);
        ll2.push(96);
        ll2.push(60);
        ll2.push(10);
        intersection = intersection.getIntersection(ll1.head, ll2.head);
        union = union.getUnion(ll1.head, ll2.head);
        System.out.println("Linked list 1: ");
        ll1.print();
        System.out.println("Linked list 2: ");
        ll2.print();
        System.out.println("Union of the linked lists: ");
        union.print();
        System.out.println("Intersection of linked lists: ");
        intersection.print();

    }

}
