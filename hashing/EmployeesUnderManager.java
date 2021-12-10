// find number of employees under every manager
import java.util.*;

public class EmployeesUnderManager {
    static Map<String, Integer> result = new HashMap<String,Integer>();
    private static void populate(Map<String,String> data){
        Map<String, List<String>> m1 = new HashMap<String,List<String>>();
        for(Map.Entry<String,String> entry : data.entrySet()){
            String emp = entry.getKey();
            String mana = entry.getValue();
            if(!emp.equals(mana)){
                List<String> drl = m1.get(mana);
                if(drl == null){
                    drl = new ArrayList<String>();
                    m1.put(mana,drl);
                }
                drl.add(emp);
            }

        }
        for(String mana : data.keySet())
            populateSec(mana,m1);
    }
    
    
    
    private static int populateSec(String mana, Map<String, List<String>> m1) {
        int count =0;
        if(!m1.containsKey(mana)){
            result.put(mana,0);
            return 0;
        }
        if(result.containsKey(mana))
            count  = result.get(mana);
        else{
            List<String> drl = m1.get(mana);
            count = drl.size();
            for(String dre : drl)
                count += populateSec(dre, m1);
        }
        return count;
    }



    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
 
        populate(dataSet);
        System.out.println("result = " + result);    
    }
}
