// Print all the permutations of the given string
public class permutations {
    static void find(String str, int l, int r){
        if(l==r)
            System.out.println(str);
        else{
            for(int i = l;i<=r;i++){
                str = swap(str,l,i);
                find(str,l+1,r);
                str = swap(str,l,i);
            }
        }
    }
    static String swap(String str, int x , int y){
        char temp;
        char[] arr = str.toCharArray();
        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return String.valueOf(arr);
    }
    public static void main(String[] args) {
        String str = "ABC";
        find(str, 0, str.length()-1);
    }
}
