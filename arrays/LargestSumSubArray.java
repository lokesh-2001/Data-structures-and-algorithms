import java.util.*;
public class LargestSumSubArray {
    public static void main(String[] args) {        
        int [] a = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println("Maximum Contiguous sum is: " + maxSum(a));
    }

    private static int  maxSum(int[] a) {
        int n = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending = 0;
        for(int i=0;i<n;i++){
            max_ending += a[i];
            if(max_so_far < max_ending)
                max_so_far = max_ending;
            if(max_ending < 0)
                max_ending = 0; 
        }
        return max_so_far;
    }
}
