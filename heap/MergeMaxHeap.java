// Merge 2 Binary Max Heaps
public class MergeMaxHeap {
    static void heapify(int arr[], int i,int n){
        int l = 2*i+1;
        int r = 2*i+2;
        int largest  = i;
        if(l<n && arr[l] > arr[largest])
            largest = l;
        else
            largest = i;
        if(r<n && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, n);
        }
    }
    static void merge(int arr[], int []a,int[]b,int n,int m){
        for(int i = 0;i<n;i++)
            arr[i] = a[i];
        for(int i = 0;i<m;i++)
            arr[n+i] = b[i];
        n = n+m;
        for(int i = n/2-1 ;i>=0;i--)
            heapify(arr, i, n);
    }
    public static void main(String[] args) {
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};
        int n = a.length;
        int m = b.length;
 
        int[] merged = new int[m + n];
 
        merge(merged, a, b, n, m);
 
        for (int i = 0; i < m + n; i++)
            System.out.print(merged[i] + " ");
 
    }

}
