// Split the Binary string into two substring with equal 0’s and 1’s
public class SplitBinaryString {
    static int split(String str, int n){
        int count_0 = 0, count_1 = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(str.charAt(i) == '0')
                count_0++;
            else
                count_1++;
            if(count_0 == count_1)
                count++;
        }
        if(count_0 !=count_1)
            return -1;
        else
            return count;
    }    
    public static void main(String[] args) {
        String str  = "0100110101";
        System.out.println(split(str,str.length()));
    }
}
