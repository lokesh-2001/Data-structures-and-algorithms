package javaImplementation;
// Check if given graph is tree or not.
import java.util.*;
public class CheckTree {
    static class graph{
        private int v;
        private LinkedList<Integer> adj[];
        @SuppressWarnings("unchecked")
        graph(int v){
            this.v = v;
            adj = new LinkedList[this.v];
            for(int i=0;i<this.v;i++)
                adj[i] = new LinkedList<Integer>();
        }
    }
    static void addEdge(graph gh, int x, int w ){
        gh.adj[x].add(w);
        gh.adj[w].add(x);
    }
    static boolean util(graph gh, int x, boolean visited[], int parent){
        visited[x] = true;
        Integer i;
        Iterator<Integer> it = gh.adj[x].iterator();
        while(it.hasNext()){
            i = it.next();
            if(!visited[i])
                if(util(gh, i, visited, x))
                    return true;
            // if it is visited and not parent of current vertex 
            // there is cycle
            else if(i!=parent)
                return true;
        }
        return false;
    }
    static boolean check(graph gh){
        boolean visited[] = new boolean[gh.v];
        for(int i =0 ;i<gh.v;i++)
            visited[i] = false;
        if(util(gh, 0, visited, -1))
            return false;
        for(int i =0 ;i<gh.v;i++)
            if(!visited[i])
                visited[i] = false;
        return true;
    }
    public static void main(String[] args) {
        graph g1 = new graph(5);
        addEdge(g1,1, 0);
        addEdge(g1,0, 2);
        addEdge(g1,0, 3);
        addEdge(g1,3, 4);
        if (check(g1))
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");
 
        graph g2 = new graph(5);
        addEdge(g2,1, 0);
        addEdge(g2,0, 2);
        addEdge(g2,2, 1);
        addEdge(g2,0, 3);
        addEdge(g2,3, 4);
        if (check(g2))
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");  
    }
}
