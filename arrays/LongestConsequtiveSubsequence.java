import java.util.*;
public class LongestConsequtiveSubsequence {
    static int longestSeq(int arr[], int n){
        HashSet<Integer> hs = new HashSet<Integer>();
        int ans = 0;
        for(int i=0;i<n;i++)
            hs.add(arr[i]);
        for(int i =0 ;i<n;i++){
            if(!hs.contains(arr[i]-1)){
                int j = arr[i];
                while(hs.contains(j))
                    j++;
                if(ans<j-arr[i])
                    ans = j-arr[i];
            }
        }
    return ans;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        int n = arr.length;
        System.out.println(
            "Length of the Longest consecutive subsequence is "
            + longestSeq(arr, n));
    }
}
