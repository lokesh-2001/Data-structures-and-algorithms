// given a list of tickets find itinerary 
// e.g
// Input:
// "Chennai" -> "Banglore"
// "Bombay" -> "Delhi"
// "Goa"    -> "Chennai"
// "Delhi"  -> "Goa"

// Output: 
// Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
import java.util.HashMap;
import java.util.Map;
public class FindItinerary {
    static void print(Map<String,String> data){
        Map<String,String> st = new HashMap<String, String>();
        for(Map.Entry<String,String> entry : data.entrySet())
            st.put(entry.getValue(),entry.getKey());
        
        String start =  null;
        for(Map.Entry<String,String> entry : data.entrySet())
            if(!st.containsKey(entry.getKey())){
                start = entry.getKey();
                break;
            }
        if(start == null){
            System.out.println("Invalid operation");
            return;
        }
        String dest = data.get(start);
        while(dest!=null){
            System.out.println(start + " -> "+ dest);
            start = dest;
            dest = data.get(dest);
        }
    }
    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");
        print(dataSet);
    }
}

