// detect a cycle in an undirected graph
import java.util.*;
public class DetectCycleUndirected {
    private int n;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked") DetectCycleUndirected(int v) {
        n = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    Boolean isCyclic(){
        Boolean visited [] = new Boolean[n];
        for(int i=0;i<n;i++)
            visited[i] = false;
        for(int i= 0 ; i<n;i++){
            if(!visited[i])
                if(isCyclicUtil(i,visited,-1))
                    return true;
        }
        return false;
    }

    private boolean isCyclicUtil(int v, Boolean[] visited, int parent) {
        visited[v]  = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();
        while(it.hasNext()){
            i = it.next();
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
            else if (i != parent)
            return true;
    
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleUndirected g = new DetectCycleUndirected(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 1);
        g.addEdge(3, 4);

        if(g.isCyclic())
            System.out.println("Contains cycle");

        else
            System.out.println("Does not contains cycle");

        // System.out.println("BFS traversal: ");
        // g.traversal(2);
    }

}
