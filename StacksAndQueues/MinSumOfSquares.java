// Minimum sum of squares of character counts in a given string after removing "k" characters.
// Given a string of lowercase alphabets and a number k, the task is to print the minimum value of 
// the string after removal of 'k' characters. The value of a string is defined as the sum of squares 
// of the count of each distinct character.
// Input :  str = abccc, K = 1
// Output :  6
// We remove c to get the value as 12 + 12 + 22


// highest element on top. 
// Initialize empty priority queue.
// Count frequency of each character and Store into temp array.
// Remove K characters which have highest frequency from queue.
// Finally Count Sum of square of each element and return it.


// import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Collections;

public class MinSumOfSquares {
    static final int MAX = 26;
    static int minValue(String str, int k){
        int n = str.length();
        if(k>=n)
            return 0;
        int[] freq = new int[MAX];
        for(int i=0;i<n;i++)
            freq[str.charAt(i) - 'a']++;

        // creating a priority queue with comparator
        // such that elements in the queue are in
        // descending order.
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<MAX;i++)
            if(freq[i]!=0)
                q.add(freq[i]);
        
        while(k!=0){
            // Get top element in priority_queue,
            // remove it. Decrement by 1 and again
            // push into priority_queue
            q.add(q.poll()-1);
            k--;
        }
        int result = 0;
        while(!q.isEmpty())
            result += q.peek() * q.poll();
        return result;
    }
    public static void main(String[] args) {
        String str = "abbccc"; 
        System.out.println(minValue(str, 2));
 
        str = "aaab"; 
        System.out.println(minValue(str, 2));
    }
}
