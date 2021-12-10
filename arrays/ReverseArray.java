public class ReverseArray {
    static void reverse(int arr[], int start, int end){
        int temp;
        if(start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, start+1, end-1);
    }    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println("Starting array");
        for (int i=0; i < arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
        reverse(arr, 0, 5);
        System.out.println("After reversing");
        for (int i=0; i < arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println("");

    }


}
