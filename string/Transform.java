// Transform One String to Another using Minimum Number of Given Operation
// The only operation allowed is to put any character from A and insert it at front
public class Transform {
    static int find(String str1, String str2){
        if(str1.length()!= str2.length())
            return -1;
        int i, j, res = 0;
        int count[] = new int[256];
        for(i = 0 ;i<str1.length();i++){
            count[str1.charAt(i)] ++;
            count[str2.charAt(i)] --;
        }
        for(i=0;i<256;i++)
            if(count[i]!=0)
                return -1;
        
        i = str1.length() - 1;        
        j = str2.length() - 1;
        
        while(i>=0){
            if(str1.charAt(i)!=str2.charAt(j))
                res++;
            else
                j--;
            i--;
        }
        return res;
    } 
    public static void main(String[] args) {
        System.out.println(find("EACBD","EABCD"));
    }
}
