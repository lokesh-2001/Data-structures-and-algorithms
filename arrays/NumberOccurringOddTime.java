// find the number occurring odd number of times
import java.util.HashMap;
public class NumberOccurringOddTime {
    static int getOdd(int arr[], int n){
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i =0 ;i<n;i++){
            if(hmap.containsKey(arr[i])){
                int val = hmap.get(arr[i]);
                hmap.put(arr[i], val+1);
            }
            else
                hmap.put(arr[i], 1);            
        
        
        }
        for(Integer a: hmap.keySet() )
            if(hmap.get(a)%2 != 0)
                return a;
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{74,21,5,21,21};
        int n = arr.length;
        System.out.println(getOdd(arr, n) + " ");
    }
}
