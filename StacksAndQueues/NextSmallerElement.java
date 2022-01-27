import java.util.Stack;
public class NextSmallerElement {
    static int arr[] = {11,13,21,3};
    static void NSE(){
        Stack<Integer> s = new Stack<>();
        int nse[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(!s.empty())
                while(!s.empty() && s.peek() >=arr[i])
                    s.pop();
            nse[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);

        }
            for(int i=0;i<arr.length;i++)
                System.out.println(arr[i] + " --> " + nse[i]); 
    }
    public static void main(String[] args) {
        NSE();
    }
}
