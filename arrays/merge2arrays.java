// Let first array be mPlusN[] and other array be N[]
// 1) Move m elements of mPlusN[] to end.
// 2) Start from nth element of mPlusN[] and 0th 
//    element of N[] and merge them into mPlusN[].
public class merge2arrays {
    static void moveEnd(int arr1[], int size) {
        int j = size - 1;
        for (int i = size - 1; i >= 0; i--) {
            if (arr1[i] != -1) {
                arr1[j] = arr1[i];
                j--;
            }

        }
    }

    static void merge(int arr[], int arr1[], int n1, int n2) {
        int i = n2;
        int j = 0;
        int k = 0;
        while (k < (n1 + n2)) {
            if ((i < (n1 + n2) && arr[i] <= arr1[j]) || j == n2) {
                arr[k] = arr [i];
                k++;
                i++;
            } 
            else {
                arr[k] = arr1[j];
                k++;j++;
            }
        }
    }
   static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
 
        System.out.println("");
    }
 
    public static void main(String[] args) {
        int arr1[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
        int arr2[] = { 5, 7, 9, 25 };
        int n = arr2.length;
        int m = arr1.length - n;
 
        /*Move the m elements at the end of mPlusN*/
        moveEnd(arr1, m + n);
        printArray(arr1, m + n);
        
        /*Merge N[] into mPlusN[] */
        merge(arr1, arr2, m, n);
 
        /* Print the resultant mPlusN */
        printArray(arr1, m + n);
    }
}

// 45 -1 58 -1 74 -1 36