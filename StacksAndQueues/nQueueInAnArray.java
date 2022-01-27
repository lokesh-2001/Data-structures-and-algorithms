// Implement n queue in an array
public class nQueueInAnArray {
    int n;
    int size;
    int [] arr;
    int [] rear;
    int [] next;
    int [] front;
    int free;
    nQueueInAnArray(int n, int size){
        this.n = n;
        this.size = size;
        this.arr = new int[size];
        this.front = new int[n];
        this.rear = new int[n];
        this.next = new int[size];
        for(int i=0;i<n;i++)
            front[i] = rear[i] = -1;
        free = 0;
        for(int i=0;i<size-1;i++)
            next[i] = i+1;
        next[size-1] = -1;
    }

    boolean isEmpty(int i){
        return front[i] == -1;
    }
    boolean isFull(int i){
        return free == -1;
    }

    void enqueue(int item, int i){
        if(isFull(i)){
            System.out.println("Queue Overflow!!");
            return ;
        }
        int nextFree = next[free];
        if(isEmpty(i))
            rear[i] = front[i] = free;
        else{
            next[rear[i]] = free;
            rear[i] = free;
        }
        next[free] = -1;
        arr[free] = item;
        free = nextFree;
    }
    int dequeue(int i){
        if(isEmpty(i)){
            System.out.println("Queue Empty!!");
            return Integer.MIN_VALUE;
        }
        int frontIndex = front[i];
        front[i] = next[frontIndex];
        next[frontIndex] = free;
        free = frontIndex;
        return arr[frontIndex];
    }

    public static void main(String[] args) {
        int n = 3, size = 10;
        nQueueInAnArray ks = new nQueueInAnArray(n,size);
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);
         
        System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));
        System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0) );
    }
}
