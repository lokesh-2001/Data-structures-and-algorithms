// block swap algorithm for array rotation
public class BlockSwapAlgo {
    // function will swap d elements at index first with d elements starting at index second
    static void swap(int arr[], int first, int second, int d){
        int temp;
        for(int i=0;i<d;i++){
            temp = arr[first+i];
            arr[first+i] = arr[second+i];
            arr[second+i] = temp;
        }
    } 
    static void print(int arr[], int size)
    {
        int i;
        for(i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }    
    static void BlockSwapRotate(int arr[], int d , int n){
        RotateBlockSwap(arr, 0, d, n);
    }
    static void RotateBlockSwap(int arr[] , int i, int d, int n){
        if(d == 0 || d == n)
            return;
        if(d-n == n){
            swap(arr, i, n-d+i, d);
            return;
        }
        if(d < n-d){
            swap(arr, i,  n-d+i, d);
            RotateBlockSwap(arr, i, d, n-d);
        }
        else{
            swap(arr, i, d, n-d);
            RotateBlockSwap(arr, n-d+i, 2*d-n, d);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        BlockSwapRotate(arr, 2, arr.length);
        print(arr,arr.length);
    }
}

