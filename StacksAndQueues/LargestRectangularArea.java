// Largest rectangular Area in Histogram
import java.util.Stack;
public class LargestRectangularArea {
    static int find(int arr[], int n){
        Stack<Integer> s = new Stack<>();
        int max = 0;
        int top = 0;
        int area;
        int i=0;
        while(i < n){
            if(s.isEmpty() || arr[s.peek()] <= arr[i])
                s.push(i++);
            else{
                top = s.peek();
                s.pop();
                area = arr[top] * (s.isEmpty() ? i : i - s.peek() -1);
                if(max < area)
                    max = area; 
            }
        }
        while(!s.isEmpty()){
            top = s.peek();
            s.pop();
            area = arr[top] * (s.isEmpty() ? i : i - s.peek() -1);
            if(max < area)
                max = area; 
        }
        return max;
    }
    public static void main(String[] args) {
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + find(hist, hist.length)); 
    }
}