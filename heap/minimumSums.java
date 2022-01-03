// minimum sums of 2 numbers formed from digits of an array
import java.util.PriorityQueue;
// We build a Min Heap with the elements of the given array, which 
// takes O(n) worst time. Now we retrieve min values (2 at a time) of 
// array, by polling from the Priority Queue and append these two min 
// values to our numbers, till the heap becomes empty, i.e., all the 
// elements of array get exhausted. We return the sum of two formed numbers, 
// which is our required answer. Overall complexity is O(nlogn) as push() 
// operation takes O(logn) and it’s repeated n times.
public class minimumSums {
    static long findSim(int[] arr){
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for(int x:arr)
            q.add(x);
        while(!q.isEmpty()){
            num1.append(q.poll()+"");
            if(!q.isEmpty())   
                num2.append(q.poll()+"");
        }
        long sum = Long.parseLong(num1.toString()) + Long.parseLong(num2.toString()); 
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {14,45,7,4,63,86,9,41,23};
        System.out.println(findSim(arr));  
    }
}
