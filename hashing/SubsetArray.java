// check if an array 2 is a subset of another array 1
// all the elements are distinct and not sorted
import java.util.HashSet;
public class SubsetArray{
    static boolean checkSubset(int arr1[], int arr2[], int n, int m){
        HashSet<Integer> hset =  new HashSet<>();
        for(int i=0;i<n;i++)
            if(!hset.contains(arr1[i]))
                hset.add(arr1[i]);
        for(int j=0;j<m;j++)
            if(!hset.contains(arr2[j]))
            return false;
        return true;
    }
    public static void main(String[] args) {
        int arr1[] = {11,1,13,21,3,7};
        int arr2[] = {11,3,7,1};
        int n = arr1.length;
        int m = arr2.length;
        if(checkSubset(arr1,arr2,n,m))
            System.out.println("true");
        else
            System.out.println("false");
    }
}