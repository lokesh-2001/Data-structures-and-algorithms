// Subset sum problem is to find subset of elements that 
// are selected from a given set whose sum adds up to a given 
// number K.
public class SubsetSumProblem {
    static int count = 0;
    // start is the starting index
    // x is the sum to be matched
    // sum is the current sum
    static void subsetSum(int list[], int sum, int start, int x){
        if(x == sum){
            count++;
            if(start < list.length)
                subsetSum(list, sum - list[start-1], start, x);
        }
        else{
            for(int i=start;i<list.length;i++)
                subsetSum(list, sum + list[i], i+1, x);
        }
    }
    public static void main(String[] args) {
        int list[] = {1,3,5,2};
        subsetSum(list, 0, 0, 6);
        System.out.println(count);
    }
}
