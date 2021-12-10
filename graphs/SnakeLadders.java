import java.util.*;
public class SnakeLadders {
    static class entry{
        int n;   // vertex number
        int distance; // distance of this vertex from source
    }
    static int minDice(int move[], int N){
        int visited[] = new int[N];
        Queue<entry> q = new LinkedList<>();
        entry qe = new entry();
        qe.n = 0 ;
        qe.distance = 0;
        visited[0] = 1;
        q.add(qe);
        while(!q.isEmpty()){
            qe = q.remove();
            int v = qe.n;
            if(v==N-1)
                break;
            for(int j = v+1;j<=(v+6)&& j<N;j++){
                if(visited[j] == 0){
                    entry a = new entry();
                    a.distance = qe.distance + 1;
                    visited[j] = 1;

                    if(move[j]!=-1)
                        a.n  =  move[j];
                    else
                        a.n = j;
                    q.add(a);
                }
            }
        }
        return qe.distance ;
    }
    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for(int i= 0;i<N;i++)
            moves[i] = -1;
        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;
 
        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("min throws required: "  + minDice(moves, N));
    }
}
