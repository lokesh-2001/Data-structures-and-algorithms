
// Topological sorting for Directed Acyclic Graph (DAG) is a linear 
// ordering of vertices such that for every directed edge u v, vertex u 
// comes before v in the ordering. Topological Sorting for a graph 
// is not possible if the graph is not a DAG.
import java.util.*;

public class TopologicalSorting {
    private int v;
    private ArrayList<ArrayList<Integer>> adj;

    TopologicalSorting(int v) {
        this.v = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
    }

    void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }

    void sortSec(int v, boolean visited[], Stack<Integer> st) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                sortSec(i, visited, st);
        }
        // push current vertex to stack which stores result
        st.push(v);

    }

    void sort() {
        Stack<Integer> st = new Stack<Integer>();
        boolean visited[] = new boolean[v];
        for(int i=0;i<v;i++)
            visited[i] = false;
        for(int i=0;i<v;i++)
            if(!visited[i])
                sortSec(i, visited, st);
        while(!st.empty())
            System.out.println(st.pop() + " ");
    }
    public static void main(String[] args) {
        TopologicalSorting g = new TopologicalSorting(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("topological sort: ");
        g.sort();   
    }

}