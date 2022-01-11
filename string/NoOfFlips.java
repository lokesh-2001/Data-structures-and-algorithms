// Number of flips to make binary string alternate
public class NoOfFlips {
    static int find(String str, int n){
        
        int ans = 0;
        for(int i= 0;i<n;i++){
            if(i%2==0 && str.charAt(i) == '1')
                ans++;
            if(i%2==1 && str.charAt(i) == '0')
                ans++;
        }
        return Math.min(ans,n-ans);
    }
    public static void main(String[] args) {
        String s = "1100";
        int len = s.length();
        System.out.print(find(s, len));
    }
}
