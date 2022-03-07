// Given an array of jobs where every job has a deadline and associated 
// profit if the job is finished before the deadline. It is also given 
// that every job takes a single unit of time, so the minimum possible deadline 
// for any job is 1. How to maximize total profit if only one job can be 
// scheduled at a time.


// Algorithm
// ? 1) Sort all jobs in decreasing order of profit. 
// ? 2) Iterate on jobs in decreasing order of profit.For each job , do the following : 
// ? a)Find a time slot i, such that slot is empty and i < deadline and i is greatest.Put the job in 
// ? this slot and mark this slot filled. 
// ? b)If no such i exists, then ignore the job. 

import java.util.Collections;
import java.util.ArrayList;
public class JobSequenceProblem {
    static class Job{
        char id;
        int deadline, profit;
        Job(){}
        Job(char i, int d, int p){
            id = i;
            deadline = d;
            profit = p;    
        }
    }        
    static void solution(ArrayList<Job> arr, int t){
        int n = arr.size();
        Collections.sort(arr,(a,b)->b.profit-a.profit);
        boolean[] result = new boolean[t];
        char job[] = new char[t];
        for(int i=0;i<n;i++){
            for (int j = Math.min(t-1,arr.get(i).deadline-1); j>=0;j--){
                if(!result[j]){
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }
        for(char jb :  job){
            System.out.println(jb + " ");
        }
    } 
    public static void main(String[] args) {
        
        ArrayList<Job> arr = new ArrayList<Job>();
  
        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        
        solution(arr, 3);
    }
}
