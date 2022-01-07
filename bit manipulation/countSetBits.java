// find the total number of set bits in a given integer 
public class countSetBits{
    static int setBits(int n){
        int count = 0;
        while(n!=0){
            n = n & (n-1);
            count ++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(setBits(9));
    }
}