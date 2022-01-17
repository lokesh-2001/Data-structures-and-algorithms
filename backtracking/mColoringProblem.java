// graph coloring problem
public class mColoringProblem {
    static final int V = 4;
    static int color[];

    // this function checks if the current color assignment is safe 
    // for vertex v
    static boolean isSafe(int v, int c, int graph[][], int color[]){
        for(int i=0;i<V;i++)
            if(graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }
    // utility function to solve the problem
    //  m- is the number of colors
    static boolean util(int graph[][], int m, int color[], int v){
        // base case of all vertices have been colored
        if(v==V)
            return true;
        for(int c = 1;c<=m;c++){
            if(isSafe(v, c, graph, color)){
                color[v] = c;
                if(util(graph, m, color, v+1))
                    return true;
                color[v] = 0;
            }
        }
        return false;
    }
    static boolean base(int graph[][], int m){
        color = new int[V];
        for(int i = 0;i<V;i++)
            color[i] = 0;
        if(!util(graph, m, color, 0)){
            System.out.println("Solution doesn't exist");
            return false;
        }
        printSol(color);
        return true;
    }
    static void printSol(int color[]){
        for(int i=0;i<V;i++)
            System.out.print(color[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        int graph[][] = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 },
        };
        int m = 3;
        base(graph, m);
    }
}
