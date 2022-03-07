import java.util.*;
public class kSortedArray {
    private static void ksort(int [] arr, int n, int k){
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int i=0;i<k+1;i++)  
            pq.add(arr[i]);
        int index = 0;
        for(int i=k+1;i<n;i++){
            arr[index++] = pq.peek();
            pq.poll();
            pq.add(arr[i]);
        }
        Iterator<Integer> it = pq.iterator();
        while(it.hasNext()){
            arr[index++] = pq.peek();
            pq.poll();
        }
    }   
    private static void print(int[] arr, int n){
        for(int i=0;i<n;i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args) {
        int k = 3;
        int arr[] = {2,6,3,12,59,8};
        int n = arr.length;
        ksort(arr, n, k);
        System.out.println("Sorted array: ");
        print(arr, n);

    }   
}
