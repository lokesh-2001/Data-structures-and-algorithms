// KMP (Knuth Morris Pratt) Pattern Searching
public class KMP {
    static void lps(String str, int m, int lps[]){
        
        int len = 0;
        // len is th length of previous longest prefix suffix
        int i = 1;
        lps[0] = 0 ;
        while(i<m){
            if(str.charAt(i) == str.charAt(len)){
                len ++ ;
                lps[i] = len;
                i++;
            }
            else{
                if(len!=0)
                    len = lps[len-1];
                else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    static void kmp(String pattern, String text){
        int m = pattern.length();
        int n = text.length();
        int lps[] = new int[m];
        int j = 0;
        lps(pattern, m, lps);
        int i =0 ;
        while(i<n){
            if(pattern.charAt(j) == text.charAt(i)){
                i++;j++;
            }
            if(j==m){
                System.out.println("Found Pattern : " + (i-j));
                j = lps[j-1];
            }
            else if(i<n && pattern.charAt(j) != text.charAt(i)){
                if(j!=0)
                    j = lps[j-1];
                else
                    i +=1;
            }
        }
    }
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        kmp(pat, txt);  
    }
}
