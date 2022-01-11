// minimum swaps to balance the given brackets at any index
public class MinSwapsToBalanceBrackets{
    static int MinSwaps(String str){
        int unbalanced = 0;
        for(int i=0;i<str.length();i++){
            if(unbalanced > 0 && str.charAt(i) ==']')
                --unbalanced;
            else if(str.charAt(i) =='[')
                ++unbalanced;
        }
        return (unbalanced + 1)/2;
    }
    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(MinSwaps(s));
    }
}