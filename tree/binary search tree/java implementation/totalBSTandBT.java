// find the total number of possible binary search trees and binary tree with n keys
import java.io.*;
public class totalBSTandBT {
    static int factorial(int n){
        int res =1;
        for(int i=1;i<=n;i++)
            res = res * i;
        return res;
    }
    static int binomialCoeff(int n, int k){
        int res = 1;
        if(k>n-k)
            k = n-k;
        for(int i=0;i<k;i++){
            res *= (n-i); 
            res /= (i+1); 
        }

        return res;
    }
    static int catalan(int n){
        int c = binomialCoeff(2*n, n);
        return c/(n+1);
    }
    static int countBT(int n){
        int count = catalan(n);
        return count;
    }
    static int countBST(int n){
        int count = catalan(n);
        return count * factorial(n);
    }
    public static void main(String[] args) {
        int count1,count2, n=5;
        count1= countBT(n);
        count2= countBST(n);
        System.out.println("count of bst with " + n +" nodes is " + count1);
        System.out.println("count of bt with " + n +" nodes is " + count2);
    }
}
