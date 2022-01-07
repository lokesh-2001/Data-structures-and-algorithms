// Given two numbers x and y, and a range [l, r] where 
// 1 <= l, r <= 32. The task is consider set bits of y in range [l, r] 
// and set these bits in x also.
public class CopySetBitsInRange {
    static int SetRange(int x, int y, int l, int r){
        if(l<1 || r>32)
            return x;
        for(int i = l;i<=r;i++){
            int mask = 1 << (i-1);
            if((y&mask) != 0 )
             x = x | mask;
        }
        return x;
    }
    public static void main(String[] args) {
        System.out.println(SetRange(10, 13, 1, 32));
    }
}
