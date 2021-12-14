// find a triplet that sum to a given value
import java.util.*;
public class TripletSum {
    static boolean triplet(int arr[],int n , int k){
        for(int i=0;i<n-2;i++){
            HashSet<Integer> hs = new HashSet<>();
            int curr = k - arr[i];
            for(int j = i+1;j<n;j++){
                if(hs.contains(curr - arr[j])){
                    System.out.print("Triplet is : " + arr[i] + " , " + arr[j] + " , " + (curr-arr[j]));
                    return true;
                }
                hs.add(arr[j]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;
 
        triplet(A, arr_size, sum);
    }
}
