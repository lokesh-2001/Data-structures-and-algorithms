// Count number of bits to be flipped to convert A to B
public class CountBits {
    static int countSetBits(int n ){
        int count = 0;
        while(n!=0){
            n &= n-1;
            count++; 
        }
        return count;
    } 
    static int flipCount(int a, int b){
        return countSetBits(a^b);
    }
    public static void main(String[] args) {
        System.out.println(flipCount(10, 20));
    }
}
