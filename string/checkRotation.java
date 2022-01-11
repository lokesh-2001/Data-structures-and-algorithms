// check whether a string is rotation of another string 
public class checkRotation {
    static boolean rotated(String str1, String str2){
        return(
            str1.toLowerCase().length() == str2.toLowerCase().length() &&
            ((str1 + str2).indexOf(str2) !=-1) 
        );
    }
    public static void main(String[] args) {
        if(rotated("Hello", "elloH"))
            System.out.println("Are Rotated");
        else
            System.out.println("Not Rotated");

    
    }
}
