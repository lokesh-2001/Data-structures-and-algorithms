// minimum swaps required to convert binary tree to binary search tree
package javaImplementation;
import java.util.*;
public class MinSwaps {
    static class Pair{
        int first,second;
        Pair(int a , int b){
            first = a;
            second = b;
        }
    }
    static void inorder(int a[], Vector<Integer> v , int n , int index){
        if(index >= n)
            return;
        inorder(a, v, n, 2*index+1);
        v.add(a[index]);
        inorder(a, v, n, 2*index+2);
    }
    static int minSwaps(Vector<Integer> v){
        int n = v.size();
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for(int i =0 ;i<n;i++)
            arr.add(new Pair(v.get(i),i));
        arr.sort(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.first - p2.first;
            }
        });
        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);
        int ans = 0;
        for(int i =0 ;i<n;i++){
            if(vis[i] || arr.get(i).first == i)
                continue;
            int cycle_size = 0;
            int j = i;
            while(!vis[j]){
                vis[j] = true;
                j = arr.get(j).second;
                cycle_size++;
            }
            if(cycle_size > 0)
                ans += cycle_size-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int a[] = { 5, 6, 7, 8, 9, 10, 11 };
        int n = a.length;
         
        Vector<Integer> v = new Vector<Integer>();
 
        inorder(a, v, n, 0);
 
        System.out.println(minSwaps(v));
    }
}
