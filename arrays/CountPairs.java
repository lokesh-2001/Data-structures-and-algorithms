// count pairs with given sum
import java.util.*;
public class CountPairs {
    static int count(int arr[], int n , int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count =0;
        for(int i=0;i<n;i++){
            if(hm.containsKey(k-arr[i])){
                count += hm.get(k-arr[i]);
            }
            else if(hm.containsKey(arr[i]))
                hm.put(arr[i],hm.get(arr[i])+1);
            else{
                hm.put(arr[i],1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
    int arr[] = { 1, 5, 7, -1, 5};
    int n = arr.length;
    int sum = 6;
    System.out.print("Count of pairs is "+ count(arr, n, sum));
    }
}
