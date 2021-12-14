// find common elements bw 3 sorted arrays without using any other data structure
public class CommonElements {
    static void common(int arr1[],int arr2[],int arr3[]){
        int i=0,j=0,k=0;
        int n1= arr1.length;
        int n2= arr2.length;
        int n3= arr3.length;
        int prev1,prev2,prev3;
        prev1=prev2=prev3 = Integer.MIN_VALUE;
        while(i<n1 && j<n2 && k<n3){
            while(i<n1 && arr1[i]<prev1)
                i++;
            while(j<n2 && arr2[j]<prev1)
                j++;
            while(k<n3 && arr3[k]<prev1)
                k++;
             if(i<n1 && j<n2 && k<n3){
                 if(arr1[i]==arr2[j] && arr2[j] == arr3[k]){
                     System.out.print(arr1[i] + " ");
                     prev1= arr1[i];
                     prev2= arr2[j];
                     prev3= arr3[k];
                     i++;
                     j++;
                     k++;
                 }
                 else if(arr1[i]<arr2[j]){
                    prev1= arr1[i];
                    i++;
                 }
                 else if(arr2[j]<arr3[k]){
                    prev2= arr2[j];
                    j++;
                 }
                 else{
                    prev3= arr3[k];
                    k++;
                 }
             }   
        }
    }
    public static void main(String[] args) {
        int arr1[] = { 1, 5, 10, 20, 40, 80, 80 };
        int arr2[] = { 6, 7, 20, 80, 80, 100 };
        int arr3[] = { 3, 4, 15, 20, 30, 70, 80, 80, 120 };
        System.out.println("Common Elements: ");
        common(arr1,arr2,arr3);   
    }
}
