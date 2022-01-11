// find duplicate characters in a string 
import java.util.HashMap;
import java.util.Map;
public class findDuplicates {
    static void duplicates(String str){
        Map<Character,Integer> hm = new HashMap<Character, Integer>();
        char[] chArray = str.toCharArray();
        for(char c : chArray){
            if(hm.containsKey(c))
                hm.put(c,hm.get(c) + 1 );
            else
                hm.put(c , 1);
        }
        for(Map.Entry<Character, Integer>entry : hm.entrySet()){
            if(entry.getValue() > 1)
                System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        duplicates("Hello World");
    }
}
