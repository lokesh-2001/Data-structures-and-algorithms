// given an array and a number x check for pair in A[] with sum as x
// import java.io.*;
import java.util.HashSet;
public class FindAPairWithGivenSum {
    static void pairs(int arr[], int sum){
        HashSet<Integer> s = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            int temp = sum - arr[i];
            if(s.contains(temp)){
                System.out.println("Pair with given sum " + sum + " is ( " + arr[i] + " , " + temp + " )");
            }
            s.add(arr[i]);
        }
    }
    public static void main(String[] args) {
        int a[] = {1,4,12,47,58,69,72};
        int x = 59;
        pairs(a, x);
    }
}
