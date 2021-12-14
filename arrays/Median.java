//  median of two sortrd arrays of different sizes 
public class Median {
    static int median(int arr1[], int arr2[], int n , int m){
        int i=0,j=0,m1=-1,m2=-1;
        if((n+m)%2!=0){
            for(int k=0;k<=(n+m)/2;k++){
                 if(i!=n && j!=m){
                     m1= (arr1[i] > arr2[j]) ? arr2[j++] : arr1[i++];
                 }
                 else if(i<n){
                     m1=arr1[i++];
                 }
                 else
                    m1=arr2[j++];
                }
                
            return m1;
        }
        else{
            for(int k=0;k<=(n+m)/2;k++){
                m2=m1;
                if(i!=n && j!=m){
                    m1= (arr1[i] > arr2[j]) ? arr2[j++] : arr1[i++];
                }
                else if(i<n){
                    m1=arr1[i++];
                }
                else
                   m1=arr2[j++];
               }
               
           return (m1+m2)/2;

        }
    }
    public static void main(String[] args) {
        int ar1[] = { 900 };
        int ar2[] = { 5, 8, 10, 20 };
     
        int n1 = ar1.length;
        int n2 = ar2.length;
     
        System.out.println(median(ar1, ar2, n1, n2));
    }
}
