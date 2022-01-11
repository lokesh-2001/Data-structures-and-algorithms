// Write a Program to check whether a string is a valid shuffle of two strings or not

public class CheckShuffle {
    static boolean check(String str1, String str2, String result){
        String str3 = str1 + str2;
        StringBuffer s = new StringBuffer(str3);

        char[] ch = result.toCharArray();
        boolean flag = false;
        if(s.length() != result.length())
            return false;
        
        for(int i = 0 ;i<ch.length;i++){
            String temp = Character.toString(ch[i]);
            if(str3.contains(temp)){
                s = s.deleteCharAt(s.indexOf(temp));
                str3 = new String(s);
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        System.out.println( check("XY", "12", "Y21X") );
    }
}
