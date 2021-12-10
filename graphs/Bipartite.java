// check whether a given graph is bipartite or not
// A Bipartite Graph is a graph whose vertices can be 
// divided into two independent sets, U and V such that 
// every edge (u, v) either connects a vertex from U to V 
// or a vertex from V to U. In other words, for every edge 
// (u, v), either u belongs to U and v to V, or u belongs 
// to V and v to U. We can also say that there is no edge 
// that connects vertices of same set.
// A bipartite graph is possible if the graph coloring is possible
// using two colors such that vertices in a set are colored with the same color. 

// grpah is represented using adjacency list
import java.util.*;
public class Bipartite{
    static class Pair{
        int first,second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }

    static boolean check(int v, ArrayList<ArrayList<Integer>> adj){
        int col[] = new int[v];
        Arrays.fill(col,-1);

        Queue<Pair> q = new LinkedList<Pair>();
        // loop in case graph is not connected
        for(int i=0;i<v;i++){
            if(col[i] == -1){
                q.add(new Pair(i,0));
                col[i] = 0;
                while(!q.isEmpty()){
                    Pair p = q.peek();
                    q.poll();

                    int n = p.first;
                    int c = p.second;
                    for(int j : adj.get(n)){
                        if(col[j] == c)
                            return false;
                        if(col[j]==-1){
                            col[j] = (c==1) ? 0 : 1;
                            q.add(new Pair(j,col[j]));
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int v = 4,e = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());
        
        adj.get(0).add(1);
        adj.get(0).add(3);

        adj.get(1).add(0);
        adj.get(1).add(2);

        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.get(3).add(0);
        adj.get(3).add(2);

        if(check(v,adj))
            System.out.println("True");
        else
            System.out.println("False");

    }
}

