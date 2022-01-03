class Node{
    int data;
    int i;
    int j;
    Node(int el, int i,int j){
        data = el;
        this.i = i;
        this.j = j;
    }
};
public class MergeKSortedArray{
    Node[] harr;
    int heap_size;
    MergeKSortedArray(Node a[], int size){
        heap_size = size;
        harr = a;
        int i = (heap_size - 1)/2;
        while (i >= 0)
        {
            MinHeapify(i);
            i--;
        }
    }
    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l].data < harr[i].data)
            smallest = l;
        if (r < heap_size && harr[r].data < harr[smallest].data)
            smallest = r;
        if (smallest != i)
        {
            swap(harr, i, smallest);
            MinHeapify(smallest);
        }
    }
    int left(int i) { return (2*i + 1); }
    int right(int i) { return (2*i + 2); }
    Node getMin()
    {
        if(heap_size <= 0)
        {
            System.out.println("Heap underflow");
            return null;
        }
        return harr[0];
    }
    void replaceMin(Node root) {
        harr[0] = root;
        MinHeapify(0);
    }
    void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void printArray(int[] arr) {
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    static void mergeArrays(int[][]arr, int k){
        Node[] a = new Node[k];
        int resultSize = 0;
        for(int i= 0;i<arr.length;i++){
            Node node = new Node(arr[i][0],i,1);
            a[i] = node;
            resultSize += arr[i].length;
        }
        MergeKSortedArray hm = new MergeKSortedArray(a,k);
        int [] result = new int[resultSize];
        for(int i = 0;i<resultSize;i++){
            Node root = hm.getMin();
            result[i] = root.data;
            if(root.j<arr[root.i].length)
                root.data = arr[root.i][root.j++];
            else
                root.data = Integer.MAX_VALUE;

            hm.replaceMin(root);
        }
        printArray(result);
    }
    public static void main(String[] args) {
        int[][] arr= {{2, 6, 12, 34},
        {1, 9, 20, 1000},
        {23, 34, 90, 2000}};

        System.out.println("Merged array is :");

        mergeArrays(arr,arr.length);

    }
}