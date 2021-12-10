// find a triplet that sum to a given value
// sort the array
// loop the array and fix the first element of the possible triplet arr[i]
// then fix the 2 pointers one at i+1 and other at n-1
    // look the sum
    // if it is smaller than increment the 1st pointer
    // if bigger decrement the second pointer
    // else print the triplet
public class TripletSumArray {
    boolean triplet(int a[], int size , int sum){
        int left,right;
        quickSort(a, 0, size-1);
        for(int i=0;i<size-2;i++){
            left = i+1;
            right=size-1;
            while(left<right){
                if(a[i] + a[left] + a[right] == sum){
                    System.out.println("Triplet is : " + a[i] + " " + a[right]+ " " + a[left] + " ");
                    return true;
                }
                else if(a[i] + a[left] + a[right] < sum)
                    left++;
                else
                    right--;
                
                
            }
        }
        System.out.println("No triplet exits");
        return false;

    }
    
    // find parition
    int partition(int A[], int start, int end){
        int x = A[end];
        int i = start-1;
        // int j;
        for(int j = start;j<end;j++){
            if(A[j]<=x){
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[end];
        A[end] = temp;
        return (i+1);
    }
    
    // quicksort
    void quickSort(int A[],int start, int end){
        int partition;
        if(start<end){
        partition =  partition(A, start, end);
        quickSort(A, start, partition-1);
        quickSort(A, partition+1,end);
        }
    }
    public static void main(String[] args) {
        TripletSumArray triplet = new TripletSumArray();
        int a[] = {1,58,96,74,23,585,25};
        int sum = 49;
        int size = a.length;
        triplet.triplet(a,size,sum);
    }
}
