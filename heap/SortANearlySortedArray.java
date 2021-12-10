// sort a nearly sorted or k-sorted array
// Given an array of n elements, where each element 
// is at most k away from its target position, devise 
// an algorithm that sorts in O(n log k) time.

// solution
// create a min heap of size k+1 with first k+1 elements
// one by one remove min element from head, put ut un result array
// and add a new element to the heap from remaining elements
import java.util.Iterator;
import java.util.PriorityQueue;

public class SortANearlySortedArray {

    static void sort(int arr[], int n, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }

        Iterator<Integer> itr = priorityQueue.iterator();

        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        sort(arr, n, k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }
}
