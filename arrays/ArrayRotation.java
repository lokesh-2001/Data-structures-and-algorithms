public class ArrayRotation {
    static void LeftRotate(int arr[], int d, int n){
        // if d > n
        d = d % n;
        int j,k,temp;
        int gcd = gcd(d, n);
        for(int i = 0;i<gcd;i++ ){
            temp = arr[i];
            j=i;
            while(true){
                k=j+d;
                if(k>=n)
                    k=k-n;
                if(k==i)
                    break;
                arr[j] = arr[k];
                j=k;
            }
            arr[j] = temp;
        }

    }
    static int gcd(int a , int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }

    static void leftRotate1(int arr[], int d){
        if(d==0)
            return;
        int n = arr.length;
        d=d%n;
        reverse(arr, 0,d-1);
        reverse(arr, d,n-1);
        reverse(arr, 0,n-1);
    }
    static void reverse(int arr[], int start, int end){
        int temp;
        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;end--;
        }
    }

    static void print(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        LeftRotate(arr, 2, 7);
        print(arr, 7);
        System.out.println();
        leftRotate1(arr, 2);
        print(arr, 7);
    }
}
