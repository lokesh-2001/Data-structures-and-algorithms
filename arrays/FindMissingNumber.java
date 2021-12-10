// using xor operation find the missing number in series of n numbers
// Assume a1 ^ a2 ^ a3 ^ …^ an = a and a1 ^ a2 ^ a3 ^ …^ an-1 = b
// Then a ^ b = an
public class FindMissingNumber {

    static int findMissing(int arr[], int n){
        int sum = ((n+1)*(n+2))/2;
        for(int i = 0;i<n;i++)
            sum -= arr[i];
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,6};
        System.out.println(findMissing(arr,arr.length));
    }
}
