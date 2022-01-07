// Find position of the only set bit
public class PositionOfOnlySetBit {
    static boolean isPowerOfTwo(int n){
        return n>0 && ((n & n-1 ) == 0);
    }
    static int findPos(int n){
        if(!isPowerOfTwo(n))
            return -1;
        int count = 0;
        while(n>0){
            n= n>>1;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 2;
        int pos = findPos(n);
        if (pos == -1)
            System.out.println("n = " + n + ", Invalid number");
        else
            System.out.println("n = " + n + ", Position " + pos);


    }
}
