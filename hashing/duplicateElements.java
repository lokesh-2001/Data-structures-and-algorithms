// check if a given array contains duplicate elements within k distance 
// from each other
import java.util.HashSet;
public class duplicateElements {
    static boolean checkDuplicates(int arr[], int k){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]))
                return true;
            set.add(arr[i]);
            if(i>=k)
                set.remove(arr[i-k]);
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {10,5,8,36,36,8,74,12,68};
        if(checkDuplicates(arr, 3))
            System.out.println("yes");
        else
            System.out.println("no");
    }

}
