// Convert a Sentence into its equivalent mobile numeric keypad sequence.
// Given a string S of size N, consisting of digits [0 – 9] and character ‘.’, 
// the task is to print the string that can be obtained by pressing the mobile keypad 
// in the given sequence. 

public class MobileNumericKeypadToSentence {
    static void print(String s) {
        String nums[] = {
                "", "", "ABC", "DEF", "GHI", "JKL", "MNO",
                "PQRS", "TUV", "WXYZ"
        };

        char str[] = s.toCharArray();
        int  i= 0;
        while(i<str.length){
            if(str[i] == '.'){
                i++;
                continue;
            }
            int count = 0;
            while(i+1<str.length && str[i] == str[i+1]){
                // count = 2,3,4,5,6&8 will have max 3 letters 
                if(count ==2 &&
                    ((str[i] >='2' && str[i] <='6') ||
                        str[i] =='8')
                ) break;
                else if(count ==3 &&
                    (str[i] =='7' || str[i] =='8')
                ) break;
                
                count++;
                i++;
                if(i == str.length)
                    break;
            }
            if(str[i]=='7' || str[i] =='9')
                System.out.print(nums[str[i] - 48].charAt(count%4));
            else
                System.out.print(nums[str[i] - 48].charAt(count%3));
            i++;
        }
    }
    public static void main(String[] args) {
        String str = "234";
        print(str);
    }
}
