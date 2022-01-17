import java.util.HashSet;
import java.util.Vector;

// Find the K-th Permutation Sequence of first N natural numbers
// Given two integers N and K, find the Kth permutation sequence of numbers from 1 to N
public class kthPermutationSequence {
    static int FirstIndex(int k,int n){
        if(n==1)
            return 0;
        n--;
        int firstIndex;
        int fact = n;
        while(k>=fact && n>1){
            fact = fact * n-1;
            n--;
        }
        firstIndex = k / fact;
        k = k % fact;
        return firstIndex;
    }
    static String FindPermutations(int n, int k){
        String ans = "";
        HashSet<Integer> hs = new HashSet<>();

        for(int i=1;i<=n;i++)
            hs.add(i);
        Vector<Integer> v = new Vector<>();
        v.addAll(hs);
        int itr = v.elementAt(0);
        k=k-1;
        for(int i=0;i<n;i++){
            int index = FirstIndex(k, n-i);
            if(index < v.size()){
                ans += ((v.elementAt(index).toString()));
                v.remove(index);
            }
            else
                ans+=String.valueOf(itr+2);

            itr = v.elementAt(0);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(FindPermutations(3, 4));
    }
}
