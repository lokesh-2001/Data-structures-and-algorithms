// Find the next Greater element
// The Next greater Element for an element x 
// is the first greater element on the right side of x in the array.
import java.util.Stack;
public class NextGreaterElement {
    static int arr[] = {11,13,21,3};
    static void NGE(){
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(!s.empty())
                while(!s.empty() && s.peek() <=arr[i])
                    s.pop();
            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);

        }
            for(int i=0;i<arr.length;i++)
                System.out.println(arr[i] + " --> " + nge[i]); 
    }
    public static void main(String[] args) {
        NGE();
    }
}
