
// Given an array of positive integers arr[] and a sum x, find all unique combinations in arr[] where the sum is equal to x.
import java.util.*;

public class CombinationSum {
    static ArrayList<ArrayList<Integer>> find(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);
        findNos(ans, arr, sum, 0, temp);
        return ans;
    }

    static void findNos(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int sum, int index,
            ArrayList<Integer> temp) {
        if(sum==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index;i< arr.size();i++){
            if((sum - arr.get(i)) >=0){
                temp.add(arr.get(i));
                findNos(ans, arr, sum-arr.get(i), i, temp);
                temp.remove(arr.get(i));
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
 
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(8);
 
        int sum = 8;
 
        ArrayList<ArrayList<Integer> > ans
            = find(arr, sum);
 
        // If result is empty, then
        if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }
 
        // print all combinations stored in ans
 
        for (int i = 0; i < ans.size(); i++) {
 
            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print(") ");
        }   
    }
}
