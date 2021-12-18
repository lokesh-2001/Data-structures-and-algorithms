import java.util.*;

public class BasicStrucutre {
    final static int max = 1000;
    static int BIT[] = new int[max];
    static int getsum(int x){
        int sum = 0 ;
        x+=1;
        while(x>0){
            sum += BIT[x];
            x = x - (x & (-x));
        }
        return sum;
    }
    static void update( int n, int x, int val){
        x+=1;
        while(x <= n){
            BIT[x] += val;
            x = x + (x & (-x));
        }
    }
    static void construct(int arr[] , int n){
        for(int i=0;i<n;i++)
            BIT[i] = 0 ;
        for(int i=0;i<n;i++)
            update(n,i,arr[i]);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,1,3,2,3,4,5,6,7,8,9};
        int n = arr.length;
        construct(arr,n);
        System.out.println("Sum of elements in arr 0 to 5 " + getsum(5));
        arr[3] += 6;
        update(n,3,6);
        System.out.println("Sum of elements in arr 0 to 5 after updation " + getsum(5));

    }
}
