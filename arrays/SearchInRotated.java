// given a sorted and rotated array find am element using binary searcg
public class SearchInRotated {

    static int search(int arr[], int n , int key){
        int pivot = pivot(arr, 0, n-1);
        if(pivot == -1) 
            binarySearch(arr, 0, n-1, key);
        if(arr[pivot] == key)
            return pivot;
        if(arr[pivot] < key)
            return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot+1, n-1, key);
        
    }

    static int pivot(int arr[], int low, int high){
        if(low>high)
            return -1;
        if(low == high)
            return low;

        int mid = (low + high) /2;
        if(mid < high && arr[mid] > arr[mid+1])
            return mid;
        if(mid > low && arr[mid] < arr[mid-1])
            return (mid-1);
        if(arr[low] >= arr[mid])
            return pivot(arr, low, mid-1);
        return pivot(arr, mid+1, high);

    }

    static int binarySearch(int arr[], int low, int high, int key){
        if(high<low)
            return -1;
        int mid = (low+high)/2;
        if(key == arr[mid])
            return mid;
        if(key > arr[mid])
            return binarySearch(arr, mid+1, high, key);
        return binarySearch(arr, low, mid-1, key);
    }

    // method 2
    static int search2(int arr[], int low , int high , int key){
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if(arr[mid] == key)
            return mid;
        if(arr[low] < arr[mid])
            if(key>=arr[low] && key<=arr[mid])
                return search2(arr, 0, mid-1, key);
            return search2(arr, mid+1, high, key);
    }


    public static void main(String[] args) {
        int arr[] = {5,6,7,8,9,10,11,12,13,14,15,1,2,3,4};
        int n = arr.length;
        System.out.println("Method 1");
        System.out.println("element found at: " + search(arr, n, 3));
        System.out.println("Method 2");
        System.out.println("element found at: " + search2(arr,0, n-1, 3));
    }
}
