// Recursively remove all adjacent duplicates
public class RemoveDuplicates {
    static String util(String str, char lastRemoved){
        if(str.length() == 0 || str.length() == 1) 
            return str;
        
        if(str.charAt(0) == str.charAt(1)){
            lastRemoved = str.charAt(0);
            while(str.length() >1 && str.charAt(0) == str.charAt(1)) 
                str = str.substring(1,str.length());
            str = str.substring(1,str.length());
            return util(str, lastRemoved);
        }
        String remainingStr = util(str.substring(1,str.length()), lastRemoved);
        if(remainingStr.length()!=0 && remainingStr.charAt(0) == str.charAt(0)){
            lastRemoved = str.charAt(0);
            return remainingStr.substring(1, remainingStr.length());
        }

        if(remainingStr.length()==0 && lastRemoved == str.charAt(0))
            return remainingStr;
        
        return (str.charAt(0) + remainingStr);
    }
    static String base(String str){
        char lastRemoved = '\0';
        return util(str, lastRemoved);
    }
    public static void main(String[] args) {
        String str1 = "azxxxzy";
        System.out.println(base(str1));
    
        String str2 = "caaabbbaac";
        System.out.println(base(str2));
    
        String str3 = "gghhg";
        System.out.println(base(str3));
    
        String str4 = "aaaacddddcappp";
        System.out.println(base(str4));
    
        String str5 = "aaaaaaaaaa";
        System.out.println(base(str5));
    
        String str6 = "qpaaaaadaaaaadprq";
        System.out.println(base(str6));
    
        String str7 = "acaaabbbacdddd";
        System.out.println(base(str7));
    
    }
}
