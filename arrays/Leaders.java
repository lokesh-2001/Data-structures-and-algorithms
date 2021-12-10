// A leader us the element which is greater than every element prsenet in its right
public class Leaders{
    static void leader(int arr[], int n){
        int max = arr[n-1];
        System.out.print(max + " ");
        for(int i=n-2;i>=0;i--){
            if(max < arr[i]){
                max = arr[i];
                System.out.print(max + " ");
            }
        }
        System.out.println();
    }   
    public static void main(String[] args) {
        int arr []  = new int[] {99,85,25,36,74,58,96,78};
        int n = arr.length;
        leader(arr,n);
    }
}