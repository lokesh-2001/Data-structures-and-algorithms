// search an element in a row wise and column wise sorted matrix
public class Search{
    static void search(int [][] arr, int n, int x){
        int i = 0, j = n-1;
        while(i<n && j>=0){
            if(arr[i][j] == x){
                System.out.println("found at {" + (i+1) + " , " + (j+1) + " }");
                return;
            }
            if(arr[i][j] > x)
                j--;
            else
                i++;
        }
        System.out.println("Not Found");
        return;
    }
    public static void main(String[] args) {
        int arr[][] = {
            { 12, 15,16,18 },
            { 22, 25,26,28 },
            { 32, 35,36,38 },
            { 42, 45,46,48 }
        };
        search(arr, 4, 36);
    }

}