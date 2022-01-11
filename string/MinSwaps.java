// minimum swaps to balance the brackets at given index
public class MinSwaps{
    static int swaps(String s){
        int unbalancedPair = 0;
        for(int i=0;i<s.length();i++){
            if(unbalancedPair > 0 && s.charAt(i) == ']')
                --unbalancedPair;
            else if(s.charAt(i) == '[')
                ++unbalancedPair;
        }
        return (unbalancedPair+1)/2;
    }
    public static void main(String[] args) {
        System.out.println(swaps("]]][[["));
    }
}