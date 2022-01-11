// Print all Subsequences of a string.
public class Subsequences{
    static void util(String str, int n , int index, String curr){
        if(index == n)
            return;
        if(curr!=null && !curr.trim().isEmpty())
            System.out.println(curr);
        for(int i = index + 1 ; i < n ; i++){
            curr += str.charAt(i);
            util(str, n, i, curr);
            curr = curr.substring(0,curr.length() - 1 );
        }
    }
    static void base(String str){
        // int index = -1;
        // String curr = "";
        util(str, str.length(), -1,"");
    }
    public static void main(String[] args) {
        base("cab");
    }
}