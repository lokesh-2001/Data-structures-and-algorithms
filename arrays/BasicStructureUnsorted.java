public class BasicStructureUnsorted{
    static int find(int arr[], int n,int key){
        // int n = arr.length;
        for(int i=0;i<n;i++)
            if(arr[i] == key)
                return i;

        return -1;
    }
    static int insert(int arr[], int n, int key, int capacity){
        if(n>= capacity)
            return n;
        arr[n] = key;
        return(n+1);
    }
    static int delete(int arr[], int n, int key){
        int pos = find(arr,n,key);
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
        // int arr[] = {74,12,45,7,5,78,96};
        int [] arr = new int[20];
        arr[0] = 74;
        arr[1] = 12;
        arr[2] = 45;
        arr[3] = 7;
        arr[4] = 5;
        arr[5] = 78;
        int capacity = 20;
        int n = 6;
        
        System.out.println("Elements before insertion: ");
        for(int i=0;i<n;i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        n = insert(arr,n,79,capacity);
        System.out.println("elements after insertion: ");
        for(int i=0;i<n;i++)
            System.out.print(arr[i] + " ");

        System.out.println();

            
        System.out.println("finding element 74 ....");
        int position = find(arr,n,74);

        if(position == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at " + position + " index");

        System.out.println();


        System.out.println("Elements before deletion: ");
        for(int i=0;i<n;i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        n = delete(arr,n,79);
        System.out.println("elements after deletion: ");
        for(int i=0;i<n;i++)
            System.out.print(arr[i] + " ");
    
    }
}