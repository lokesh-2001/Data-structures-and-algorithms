//* Merge Overlapping Intervals using stack
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
public class MergeOverlappingIntervals {
    static class interval{
        int start,end;
        interval(int st,int en){
            start = st;
            end = en;
        }
    }
    public static void main(String args[]){
        interval arr[] = new interval[4];
        arr[0] = new interval(6,8);
        arr[1] = new interval(1,9);
        arr[2] = new interval(2,4);
        arr[3] = new interval(4,7);
        merge(arr);
    }
    static void merge(interval arr[]){
        if(arr.length <= 0)
            return;
        Stack<interval> st = new Stack<>();
        Arrays.sort(arr,new Comparator<interval>(){
            public int compare(interval i1, interval i2){
                return i1.start - i2.start;
            }
        });

        st.push(arr[0]);
        for(int i=0;i<arr.length;i++){
            interval top = st.peek();
            if(top.end<arr[i].start)
                st.push(arr[i]);
            else if(top.end < arr[i].end){
                top.end = arr[i].end;
                st.pop();
                st.push(top);
            }
        }
        System.out.println("Merged Intervals: ");
        while(!st.isEmpty()){
            interval t = st.pop();
            System.out.println("[ " + t.start + " , " + t.end + " ] ");
        }
    }
}
