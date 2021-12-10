public class BasicStructureSorted {
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
    static int insert(int arr[], int n , int key, int capacity){
        if(n>=capacity)
            return n;
        int i;
        for(i = n-1; (i>=0 && arr[i]>key) ; i--)
            arr[i+1] = arr[i];
        arr[i+1] = key;
        return(n+1);
    }
    static int delete(int arr[], int n, int key){
        int pos = binarySearch(arr, 0,n-1, key);
        if(pos == -1){
            System.out.println("element not found");
            return n;
        }
        int i ;
        for(i = pos;i<n-1;i++)
            arr[i] = arr[i+1];
        return n-1;


    }
    public static void main(String[] args) {
        // int arr[] = {5,6,7,8,9,10,11};
        int arr[] = new int[20];
        arr[0] = 6; 
        arr[1] = 7; 
        arr[2] = 8; 
        arr[3] = 10; 
        arr[4] = 11; 
        arr[5] = 12; 
        int n = 6;

        System.out.println("Insertion operation: ");
        System.out.println("before insertion");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    
            n = insert(arr, n, 9, 20);
        System.out.println();
        System.out.println("after insertion");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        
        System.out.println();
        System.out.println();
            
        System.out.println("Search opertion: ");        
        System.out.println("element found at : " + binarySearch(arr, 0, n,10));
        
        System.out.println();
        System.out.println();
        
        System.out.println("deletion operation: ");
        System.out.println("before deletion");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    
            n = delete(arr, n, 9);
        System.out.println();
        System.out.println("after deletion");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");


    }
}
