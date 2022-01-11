// reverse a string
public class reverse{
    static void reverseString(String str){
        String result= "";
        System.out.println(str);        
        for(int i = str.length()-1;i>=0;i--)
            result += str.charAt(i);
        System.out.println(result);        
    }
    public static void main(String[] args){
        reverseString("Hello world");
    }
}