// union-find algorithm to detect cycle in the graph
// no self loops in the graph 
import java.util.*;
public class DetectCycleDirected2 {    
    int v,e;
    // no of vertices and no of edges
    Edge edge[];
    class Edge{
        int src, dest;
    };
    DetectCycleDirected2(int v, int e){
        this.v = v;
        this.e = e;
        edge = new Edge[e];
        for(int i=0;i<e;i++)
            edge[i] = new Edge();
    }  
    // function to find the subset of the element
    int find (int parent[],int i){
        if(parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }  
    void union(int parent[], int x , int y){
        parent[x] = y;
    }

    boolean isCycle(DetectCycleDirected2 graph){
        int parent[] =  new int[graph.v];
        for(int i=0;i<graph.v;i++)
            parent[i] = -1;
        for(int i=0;i<graph.v;i++){
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);
            if(x==y)
                return true;
            graph.union(parent, x, y);
        }
        return false;
    }
    public static void main(String[] args) {
        int v = 3, e = 3;
        DetectCycleDirected2 graph = new DetectCycleDirected2(v,e);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if(graph.isCycle(graph))
            System.out.println("contains cycle");
        else
            System.out.println("no cycle");
    }
}
