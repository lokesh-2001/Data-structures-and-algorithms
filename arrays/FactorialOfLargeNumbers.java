import java.math.BigInteger;

public class FactorialOfLargeNumbers {
    static void factorial(int n){
        int res[] = new int[500];
        res[0] =1;
        int result = 1;
        for(int i =2;i<=n;i++)
            result = multiply(i,res,result);
        System.out.println("Factorial: ");
        for(int i=result-1;i>=0;i--)
            System.out.print(res[i]);
    }
    static int multiply(int i, int res[],int result){
        int carry=0;
        for(int j=0;j<result;j++){
            int prod = res[j] * i +carry;
            res[j] = prod % 10;
            carry = prod/10;
        }
        while(carry!=0){
            res[result]=  carry %10;
            carry = carry/10;
            result++;
        }
        return result;
    }
    // method 2
    // using BigInteger
    static void factorial2(int n){
        BigInteger  bg = new BigInteger("1");
        for(int i=2;i<=n;i++)
            bg = bg.multiply(BigInteger.valueOf(i));
        System.out.println("Factorial method 2: ");
        System.out.println(bg);
    }
    public static void main(String[] args) {
        factorial(100);
        System.out.println();
        System.out.println();
        factorial2(100);
    }

}
