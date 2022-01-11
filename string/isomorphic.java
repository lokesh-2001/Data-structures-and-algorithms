import java.util.Arrays;

// Check if two given strings are isomorphic to each other
// Two strings str1 and str2 are called isomorphic if there is a one-to-one 
// mapping possible for every character of str1 to every character of str2. 
// And all occurrences of every character in 'str1' map to the same character in 'str2'.
public class isomorphic {
    static int size = 256;
    static boolean check(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        if(m!=n)
            return false;
        Boolean[] marked = new Boolean[size];
        Arrays.fill(marked, Boolean.FALSE);
        int [] arr = new int [size];
        Arrays.fill(arr, -1);
        for(int i=0;i<n;i++){
            if(arr[str1.charAt(i)] == -1){
                if(marked[str2.charAt(i)])
                    return false;
                marked[str2.charAt(i)] = true;
                arr[str1.charAt(i)] = str2.charAt(i);
            }
            else if(arr[str1.charAt(i)] != str2.charAt(i))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(check("aab", "xxy"));
    }
}
