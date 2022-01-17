import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
public class ValidParenthesis {
    static boolean checkParenThesis(char c) {
        return ((c == ')') || (c == '('));
    }

    // check's if it contains valid parenthesis pair
    static boolean checkValidString(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                count++;
            else if (str.charAt(i) == ')')
                count--;
            if(count<0)
                return false;
        }
        return (count == 0);
    }

    static void removeParenthesis(String str) {

        if (str.isEmpty())
            return;
        HashSet<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        String temp ;
        boolean level = false;
        // level is made true when a valid string is found at that current level

        q.add(str);
        visited.add(str);
        while(!q.isEmpty()){
            str = q.peek();
            q.remove();

            if(checkValidString(str)){
                System.out.println(str);
                level = true;
            }
            if(level)
                continue;
            for(int i = 0;i<str.length();i++){
                if(!checkParenThesis(str.charAt(i)))
                        continue;
                // removing parenthesis from str
                temp = str.substring(0,i) + str.substring(i+1);
                if(!visited.contains(temp)){
                    q.add(temp);
                    visited.add(temp);
                }
            }
        }
    }
    public static void main(String[] args) {
        String str = "()())()";
        removeParenthesis(str);
     
        str = "()v)";
        removeParenthesis(str);
    
    }
}