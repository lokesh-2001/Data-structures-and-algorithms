import java.io.*;
import java.util.*;

public class BFS {
    private int n;
    private LinkedList<Integer> adj[];

    BFS(int v) {
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
        LinkedList<Integer> ll = new LinkedList<Integer>();
        visited[x] = true;
        ll.add(x);
        while (ll.size() != 0) {
            x = ll.poll();
            System.out.println(x + " ");
            Iterator<Integer> i = adj[x].listIterator();
            while(i.hasNext()){
                int s = i.next();
                if(!visited[s]){
                    visited[s] = true;
                    ll.add(s);
                } 
            }
        }
    }
    public static void main(String[] args) {
        BFS g = new BFS(4);
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
