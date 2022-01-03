// convert min heap to max heap
public class Conversion{
    static void heapify(int arr[], int i ,int n){
        int l = 2*i+1;
        int r = 2*i+2;
        int largest  = i;
        if(l<n && arr[l] > arr[largest])
            largest = l;
        if(r<n && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, n);
        }
    }
    static void convert(int arr[], int n){
        for(int i = (n-2)/2;i>=0;i--)
            heapify(arr, i, n);
    }
    static void printArray(int arr[], int size)
    {
        for (int i = 0; i < size; ++i)
            System.out.print(arr[i]+" ");
    }
    public static void main (String[] args)
    {
        int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int n = arr.length;
        System.out.print("Min Heap array : ");
        printArray(arr, n);
        convert(arr, n);
        System.out.print("\nMax Heap array : ");
        printArray(arr, n);
    }
}