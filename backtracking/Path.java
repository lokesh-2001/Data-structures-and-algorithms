// Find if there is a path of more than k length from a source
// Given a graph, a source vertex in the graph and a number k, find if 
// there is a simple path (without any cycle) starting from given source 
// and ending at any other vertex such that the distance from source to 
// that vertex is at least "k" length.
import java.util.ArrayList;
import java.util.Arrays;
public class Path {
    static class ListNode{
        int V, weight;
        ListNode(int v, int w){
            V = v; weight = w;
        }
        int getV(){return V;}
        int getWeight(){return weight;}
    }
    static class graph{
        int N;
        ArrayList<ArrayList<ListNode>> adj;
        graph(int v){
            N = v;
            adj = new ArrayList<ArrayList<ListNode>>();

            for(int i=0;i<v;i++)
                adj.add(new ArrayList<ListNode>());
        }
        void addEdge(int u, int v, int weight){
            ListNode node1 = new ListNode(v,weight);
            adj.get(u).add(node1);
            ListNode node2 = new ListNode(u,weight);
            adj.get(v).add(node2);
        }
        boolean util(int src, int k, boolean[] path){
            if(k<=0)
                return true;
            ArrayList<ListNode> it = adj.get(src);
            int index = 0 ;
            for(int i=0;i<adj.get(src).size();i++){
                ListNode vertex = adj.get(src).get(i);
                int v = vertex.V;
                int w = vertex.weight;
                index++;
                // case of cycle
                // already exists in path
                if(path[v])
                    continue;
                if(w>=k)
                    return true;
                path[v] = true;
                if(util(v, k-w, path))
                    return true;        
                path[v] = false;
            }
            return false;
        }
        boolean base(int src, int k){
            boolean path[] = new boolean[N];
            Arrays.fill(path, false);
            path[src] = true;
            return util(src, k, path);
        }
    }
    public static void main(String[] args) {
        int V = 9;
        graph g = new graph(V);
     
        // making above shown graph
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
     
        int src = 0;
        int k = 62;
     
        if(g.base(src, k))
          System.out.println("YES");
        else
          System.out.println("NO");
     
     
        k = 60;
        if(g.base(src, k))
          System.out.println("YES");
        else
          System.out.println("NO");
       
    }

}
