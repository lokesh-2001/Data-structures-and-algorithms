// LRU Cache Implementation
// We are given total possible page numbers 
// that can be referred. We are also given cache (or memory) 
// size (Number of page frames that cache can hold at a time). 
// The LRU caching scheme is to remove the least recently used 
// frame when the cache is full and a new page is referenced which 
// is not there in cache.

// We use two data structures to implement an LRU Cache.  

// Queue which is implemented using a doubly linked list. 
// The maximum size of the queue will be equal to the total 
// number of frames available (cache size). The most recently used 
// pages will be near front end and least recently pages will be near the rear end.
// A Hash with page number as key and address of the corresponding 
// queue node as value.

// using linked hashset
import java.util.*;
public class LRUCache {
    Set<Integer> cache;
    int capacity;
    public LRUCache(int cap){
        cache = new LinkedHashSet<Integer>(cap);
        this.capacity = cap;
    }
    
    boolean get(int key){
        if(!cache.contains(key))
            return false;
        cache.remove(key);
        cache.add(key);
        return true;
    }
    void refer(int key){
        if(!get(key))
            put(key);
    }
    void put(int key){
        if(cache.size() == capacity){
            int first = cache.iterator().next();
            cache.remove(first);
        }
        cache.add(key);
    }
    void display(){
        LinkedList<Integer> li = new LinkedList<>(cache);
        Iterator<Integer> itr = li.descendingIterator();
        while(itr.hasNext())
            System.out.print(itr.next() + " ");
    }
    public static void main(String[] args) {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
