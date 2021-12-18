// print unique rows in a given boolean matrix
import java.util.*;
public class UniqueRows {
    public static void printUnique(int arr[][], int row, int col){
        HashSet<String> hs = new HashSet<String>();
        for(int i=0;i<row;i++){
            String s = "";
            for(int j =0;j<col;j++)
                s+= String.valueOf(arr[i][j]);
            if(!hs.contains(s)){
                hs.add(s);
                System.out.println(s);
            }
        }
    }
    public static void main(String[] args) {
        int arr[][] = {
            {0,1,0,1},
            {0,1,1,1},
            {0,1,0,1},
            {1,1,0,1}
        };
        printUnique(arr,4,4);
    }
}
