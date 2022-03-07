// detect cycle in a graph
import java.util.*;
public class DetectCycleDirectedDFS {
    private final int n;
    private final List<List<Integer>> adj;
    DetectCycleDirectedDFS(int v){
        this.n = v;
        adj  = new ArrayList<>(n);
        for(int i=0;i<v;i++)
            adj.add(new LinkedList<>());
    }
    private void addEdge(int source, int destination){
        adj.get(source).add(destination);
    }
    private boolean cyclicSec(int i, boolean[] visited, boolean[]recstack){
        if(recstack[i])
            return true;
        if(visited[i])
            return false;
        visited[i] = true;
        recstack[i] = true;

        List<Integer> children = adj.get(i);
        for(Integer c : children)
            if(cyclicSec(c,visited,recstack))
                return true;
        recstack[i]  = false;
        return false;
    }   
    private boolean isCyclic(){
        boolean[] visited = new boolean[n];  
        boolean[] recStack = new boolean[n];
        
        for(int i=0;i<n;i++)
            if(cyclicSec(i,visited,recStack))
                return true;
        return false;
    }
    public static void main(String[] args) {
        DetectCycleDirectedDFS g = new DetectCycleDirectedDFS(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);


        if(g.isCyclic())
            System.out.println("contains Cycle");
        else
            System.out.println("does not contains Cycle");

    }
}
