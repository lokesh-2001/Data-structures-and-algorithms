import java.io.*;
import java.util.*;

public class DFS {
    private int n;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked") DFS(int v) {
        n = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void traversal(int x) {
        boolean visited[] = new boolean[n];
        // for fully connected graph
        // traversalUtil(x,visited);

        // if the graph contains disconnected nodes
        // Run a loop from 0 to the number of vertices 
        // and check if the node is unvisited in the previous
        // DFS, call the recursive function with the current node.   

        for(int i=0;i<x;i++)
            if(!visited[i])
                traversalUtil(i,visited);

    }
    void traversalUtil(int x, boolean visited[]){
        visited[x] = true;
        System.out.println(x + " ");
        Iterator<Integer> i = adj[x].listIterator();
        while(i.hasNext()){
            int s  = i.next();
            if(!visited[s])
                traversalUtil(s,visited);
        }

    }


    public static void main(String[] args) {
        DFS g = new DFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS traversal: ");
        g.traversal(2);
    }

}
