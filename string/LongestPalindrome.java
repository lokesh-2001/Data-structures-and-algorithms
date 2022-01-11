public class LongestPalindrome {
    static void printStr(String str, int low, int high){
        System.out.println(str.substring(low,high+1));
    }
    static int find(String str){
        int maxLen = 1;
        int start = 0;
        int len = str.length();
        int low,high;
        for(int i = 1 ; i<len;i++){
            low = i-1;
            high = i;
            while(low>=0 && 
                high < len && 
                str.charAt(low) == str.charAt(high)
            ){
                --low;
                ++high;
            }
            ++low; --high;
            if(str.charAt(low) == str.charAt(high) && high-low+1 > maxLen){
                start = low;
                maxLen = high - low +1;
            }
            low = i-1;
            high = i+1;
        }
        printStr(str,start,start+maxLen-1);
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(find("forgeeksskeegfor"));
    }
}
