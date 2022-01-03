// median in a stream of integers (running integers)
import java.util.Collections;
import java.util.PriorityQueue;
public class MedianInIntegers {
    static void printMedian(int []arr){
        double md = arr[0];
        // max heap to store the smaller half elements
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        // min heap to store the greater half elements
        PriorityQueue<Integer> greater = new PriorityQueue<>();

        smaller.add(arr[0]);
        System.out.println("median : " + md);
        /* At any time we try to make heaps balanced and
        their sizes differ by at-most 1. If heaps are
        balanced,then we declare median as average of
        min_heap_right.top() and max_heap_left.top()
        If heaps are unbalanced,then median is defined
        as the top element of heap of larger size */
        
        for(int i = 1;i<arr.length;i++){
            int x = arr[i];
            // case 1 left side heap has more elements
            if(smaller.size() > greater.size()){
                if(x < md){
                    greater.add(smaller.remove());
                    smaller.add(x);
                }
                else
                    greater.add(x);
                
                    md = (double)(smaller.peek() + greater.peek())/2;
            }
            // case 2 both heaps are balanced
            else if(smaller.size() == greater.size()){
                if(x < md){
                    smaller.add(x);
                    md = (double)smaller.peek();
                }
                else{
                    greater.add(x);
                    md = (double)greater.peek();
                }
            }
            // case 3 left side heap has less elements
            else{
                if(x > md){
                    smaller.add(greater.remove());
                    greater.add(x);
                }
                else
                    smaller.add(x);
                
                    md = (double)(smaller.peek() + greater.peek())/2;
            }
            System.out.println("median : " + md);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        printMedian(arr);
    }
}
// Note that output is the effective median of integers read 
// from the stream so far. Such an algorithm is called an online 
// algorithm. Any algorithm that can guarantee the output of i-elements 
// after processing i-th element, is said to be online algorithm. 