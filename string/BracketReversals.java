// Minimum number of bracket reversals needed to make an expression balanced.
public class BracketReversals {
    static int count(String str){
        int len = str.length();
        if(len%2!=0)
            return-1;
        int ans = 0;
        int open = 0;
        int close = 0;
        int i;
        for (i = 0; i < len; i++)
        {
            if (str.charAt(i) == '{')
                open++;
            else
            {
                if (open == 0)
                    close++;
                else
                    open--;
            }
        }
        ans = (close / 2) + (open / 2);
        close %= 2;
        open %= 2;
        if (close != 0)
            ans += 2;
     
        return ans;
    }
    public static void main(String args[]){
        String expr = "}}{{";
        System.out.println(count(expr));
    }

}
