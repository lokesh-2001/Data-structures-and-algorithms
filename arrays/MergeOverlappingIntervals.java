// merge overlapping intervals
import java.util.*;
// arrays, stack and comparator
class Interval{
    int start,end;
    Interval(int st, int ed){
        start = st;
        end = ed;
    }
}
public class MergeOverlappingIntervals {
    static void merge(Interval arr[]){
        if(arr.length <= 0 )
            return;
        Stack<Interval> st = new Stack<>();
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            Interval top = st.peek();
            if(top.end < arr[i].start)
                st.push(arr[i]);
            else if (top.end < arr[i].end){
                top.end = arr[i].end;
                st.pop();
                st.push(top);
            }
        }
        System.out.println("Merged Intervals: ");
        while(!st.isEmpty()){
            Interval t = st.pop();
            System.out.println("[ " + t.start + " , " +t.end + " ]" );
        }

    }
    static void merge2(Interval arr[]){
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int index =0 ;
        for(int i =1;i<arr.length;i++){
            if(arr[index].end >= arr[i].start){
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
            }
            else{
                index ++;
                arr[index] = arr[i];
            }
        }
        System.out.println("Merged Intervals Method 2: ");
        for(int i =0 ;i<=index;i++){
            System.out.println("[ " + arr[i].start + " , " +arr[i].end + " ]" );
        }
    }
    public static void main(String[] args) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        merge(arr);
        System.out.println("Using method 2: ");   
        System.out.println();   
        System.out.println();
        merge2(arr);
    }

}
