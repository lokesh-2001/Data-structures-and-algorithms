// find inversion count of an array using BIT
public class InversionCount {
    // final static int max = 1000;
    // static int BIT[] = new int[max];
    static int getsum(int BIT[], int x){
        int sum = 0 ;
        x+=1;
        while(x>0){
            sum += BIT[x];
            x = x - (x & (-x));
        }
        return sum;
    }
    static void update(int BIT[], int n, int x, int val){
        x+=1;
        while(x <= n){
            BIT[x] += val;
            x = x + (x & (-x));
        }
    }
    static int inversion(int arr[], int n){
        int count = 0;
        int max =0 ;
        for(int i =0 ;i<n;i++)
            if(max < arr[i])
                max = arr[i];
        int[] BIT = new int[max + 1];
        for(int i =1 ;i<=max ;i++)
            BIT[i] = 0;
        for(int i = n-1;i>=0;i--){
            count = count + getsum(BIT, arr[i]-1);
            update(BIT, max, arr[i], 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {8,4,2,1};
        int n = arr.length;
        System.out.println("Inversion Count: "  + inversion(arr,n));

    }
}
