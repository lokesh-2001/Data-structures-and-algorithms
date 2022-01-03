import java.util.PriorityQueue;
public class kthLargestSmallestElement {
    static int findKthLargest(int arr[], int k){
        PriorityQueue<Integer> q  = new PriorityQueue<Integer>();
        for(int i : arr){
           q.offer(i);
           if(q.size() > k)
                q.poll();
        }
        return q.peek();
    }    
    static int findKthSmallest(int arr[], int k){
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();

        for (int i = 0; i < arr.length; i++)  
            q.offer(arr[i]);  
        int currentNo = 0; 
        while (k > 0) {
            currentNo = q.poll();
            k--;
        }  
        return currentNo;
    }
    public static void main(String[] args) {
        int arr[] = {10,2,7,3,9,4,1,0};
        System.out.println(findKthLargest(arr,3));
        System.out.println(findKthSmallest(arr,3));
    }
}
// Suppose, we want to retrieve elements in the ascending 
// order. In this case, the head of the priority queue will 
// be the smallest element. Once this element is retrieved, 
// the next smallest element will be the head of the queue.
