// Sliding Window Maximum (Maximum of all subarrays of size k)
// using dynamic programming // only correct for k = 3
import java.util.LinkedList;
import java.util.Deque;
public class MaximumOfSubarraysOfSizek {
    static void find(int arr[], int n , int k){
        if(k==1){
            for(int i=0;i<n;i++)
                System.out.print(arr[i]+" ");
            return;
        }
        int left[] = new int[n];
        int right[] = new int[n];
        for(int i=0;i<n;i++){
            if(i%k == 0)
                left[i] = arr[i];
            else 
                left[i] = Math.max(left[i-1],arr[i]);

            if((n-1)%k==0 || i==0)
                right[n-i-1] = arr[n-i-1];
            else
            right[n-i-1] = Math.max(right[n-i],arr[n-1-i]);
        }
        for(int i=0,j=k-1;j<n;i++,j++)
            System.out.print(Math.max(left[j],right[i])+ " ");
    }

    // using deque
    static void findDeque(int arr[], int n, int k){
        Deque<Integer> q = new LinkedList<Integer>();
        int i;
        for(i=0;i<k;i++){
            while(!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }
        for(;i<n;i++){
            System.out.print(arr[q.peek()] + " ");
            while(!q.isEmpty() && q.peek() <= i-k)
                q.removeFirst();
            while(!q.isEmpty() && arr[i] >= arr[q.peekLast()])
                q.removeLast();
            q.addLast(i);
        }
        System.out.print(arr[q.peek()]);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        find(arr,arr.length,4); 
        System.out.println();
        findDeque(arr,arr.length,4);
    }
}
// left[i] is the maximum of all elements that are to the left of current 
// element(including current element) in the current block(block in which current 
// element is present).
// Similarly, right[i] is the maximum of all elements that are to the right of 
// current element(including current element) in the current block(block in which 
// current element is present).
// Finally, when calculating the maximum element in any subarray of length k, we 
// calculate the maximum of right[l] and left[r]
// where l = starting index of current sub array, r = ending index of current sub array
