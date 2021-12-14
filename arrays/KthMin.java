// using min heap
// call the function k times to find kth smallest element
public class KthMin {
    class Heap{
        int[] arr;
        int capacity;
        int size;
        int parent(int i){
            return (i-1)/2;
        }
        int left(int i){
            return 2*i + 1;
        }
        int right(int i){
            return 2*i + 2;
        }
        int getMin(){
            return arr[0];
        }
        void replaceNode(int x){
            this.arr[0] = x;
            heapify(0);
        }
        Heap(int arr[], int size){
            this.size = size;
            this.arr = arr;
            int i = (size-1);
            while(i>=0){
                heapify(i);
                i--;
            }
        }   
        void heapify(int i){
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if(l<this.size && arr[l]<arr[i])
                smallest = l;
            if(r<this.size && arr[r]<arr[smallest])
                smallest = r;
            if(smallest!=i){
                // swap arr[i] and arr[smallest]
                int t = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = t;
                heapify(smallest);
            }
        }

        int extractMin(){
            if (size==0)
                return Integer.MAX_VALUE;
            int root = arr[0];
            if(size>1){
                arr[0] = arr[size-1];
                heapify(0);
            }
            size--;
            return root;
        }
    };

    int kthMin(int arr[], int n, int k){
        Heap hp = new Heap(arr,n);
        for(int i = 0;i<k-1;i++)
            hp.extractMin();
        
        return hp.getMin();
    }
    public static void main(String[] args) {
        int arr[] = { 12, 3, 5, 7, 19 };
        int n = arr.length, k = 2;
        KthMin kth = new KthMin();
        System.out.println("kth smallest element: " + kth.kthMin(arr, n, k)); 
    }
}
