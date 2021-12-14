// rearrange elements in alternating +ve & -ve items
import java.util.*;
public class RearrangeElements {
    static void negativeFill(int a[], int neg, int pos){
        if(pos%2==1){
            for(int i=1;i<pos;i+=2){
                int temp = a[i];
                a[i] = a[i+pos];
                a[i+pos] = temp;
            }
        }
        else{
            for(int i=1;i<=pos;i+=2){
                int temp = a[i];
                a[i] = a[i+pos-1];
                a[i+pos-1] = temp;
            }
        }
    }
    static void positiveFill(int a[], int neg, int pos){
        if(neg%2==1){
            for(int i=1;i<neg;i+=2){
                int temp = a[i];
                a[i] = a[i+neg];
                a[i+neg] = temp;
            }
        }
        else{
            for(int i=1;i<=neg;i+=2){
                int temp = a[i];
                a[i] = a[i+neg-1];
                a[i+neg-1] = temp;
            }
        }
    }
    static void reverse(int a[], int n){
        int i,  t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
    static void print(int a[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        int n = arr.length;
 
        int neg = 0, pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                neg++;
            else
                pos++;
        }
        // Sort the array
        Arrays.sort(arr);
 
        if (neg <= pos) {
            positiveFill(arr, neg, pos);
        }
        else {
            // reverse the array in this condition
            reverse(arr, n);
            negativeFill(arr, neg, pos);
        }
        print(arr, n);
    }
}

