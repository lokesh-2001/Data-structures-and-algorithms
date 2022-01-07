//  Find the two non-repeating elements in an array of repeating elements/ Unique Numbers 2
//  Given an array in which all numbers except two are repeated once. (i.e. we have 2n+2 
//  numbers and n numbers are occurring twice and remaining two have occurred once). Find those two numbers 
//  using bit manipulation
public class RepeatingNumbersInAnArray{
    static void findNumbers(int[] arr){
        int n = arr.length;
        int xor = arr[0];
        for(int i = 1;i<n;i++)
            xor = xor ^ arr[i];
        int rightSetBit = xor & ~(xor-1);
        int x= 0, y=0;
        for(int i = 0;i<n;i++){
            if((arr[i] & rightSetBit) == 1)
                x = x ^ arr[i];
            else
                y = y ^ arr[i];
        }
        if(y>x)
            System.out.println(x + " " + y);
        else
            System.out.println(y + " " + x);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,2,4};
        findNumbers(arr);
    }
}