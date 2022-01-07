// to find whether a no is power of two
public class NoIsPowerOf2 {
    static int countSetBits(int n ){
        int count = 0;
        while(n!=0){
            n &= n-1;
            count++; 
        }
        return count;
    } 
    public static void main(String[] args) {
        if(countSetBits(4) == 5)
            System.out.println("Yes");
        else
            System.out.println("No");

    }

}
