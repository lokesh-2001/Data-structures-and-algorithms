// Maximum sum such that no two elements are adjacent
public class MaximumSum {
    static int findMax(int arr[], int n){
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i; 
        for (i = 1; i < n; i++){
            excl_new = (incl > excl) ? incl : excl;
            incl = excl + arr[i];
            excl = excl_new;
        }
 
        return ((incl > excl) ? incl : excl);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(findMax(arr, arr.length));
    }
}

