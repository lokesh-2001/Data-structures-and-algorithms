// Kth largest sum continuous subarrays
import java.util.PriorityQueue;
public class ContiguousSubarray {
    static int find(int arr[], int n, int k){
        int sum[] = new int[n+1];
        sum[0] = 0;
        sum[1] = arr[0];
        for(int i =2;i<=n;i++)
            sum[i] = sum[i-1] + arr[i-1];
        
            PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                int x = sum[j] - sum[i-1];
                if(q.size() < k)
                    q.add(x);
                else{
                    if(q.peek() <x){
                        q.poll();
                        q.add(x);
                    }
                }
            }
        }
        return q.poll();
    }   
    public static void main(String[] args) {
        int a[] = new int[]{ 10, -10, 20, -40 };
        System.out.println(find(a, a.length ,6));
    
    }
}
