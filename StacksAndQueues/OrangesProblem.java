// Minimum time required to rot all oranges
// Given a matrix of dimension m*n where each cell in the matrix 
// can have values 0, 1 or 2 which has the following meaning:  

// 0: Empty cell
// 1: Cells have fresh oranges
// 2: Cells have rotten oranges

// Determine what is the minimum time required so that all the 
// oranges become rotten. A rotten orange at index [i,j] can rot 
// other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] 
// (up, down, left and right). If it is impossible to rot every 
//  then simply return -1.

import java.util.LinkedList;
import java.util.Queue;

public class OrangesProblem {
    final static int R = 3;
    final static int C = 5;

    static class element {
        int x = 0, y = 0;

        element(int a, int b) {
            x = a;
            y = b;
        }
    }

    static boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < R && j < C);
    }

    static boolean isDelim(element temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    // function to check is there is a fresh orange or not
    static boolean checkFresh(int arr[][]) {
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 1)
                    return true;
        return false;
    }

    static int rotten(int arr[][]) {
        Queue<element> q = new LinkedList<>();
        element temp;
        int ans = 0;

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (arr[i][j] == 2)
                    q.add(new element(i, j));

        q.add(new element(-1, -1));

        while (!q.isEmpty()) {
            // This flag is used to determine whether even a single fresh
            // orange gets rotten due to rotten oranges in the current time
            // frame so we can increase the count of the required time.
            boolean flag = false;

            while (!isDelim(q.peek())) {
                temp = q.peek();
                // check right
                if (isValid(temp.x + 1, temp.y) && arr[temp.x + 1][temp.y] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x + 1][temp.y] = 2;
                    temp.x++;
                    q.add(new element(temp.x, temp.y));
                    temp.x--;
                }
                // check left
                if (isValid(temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x - 1][temp.y] = 2;
                    temp.x--;
                    q.add(new element(temp.x, temp.y));
                    temp.x++;
                }
                // check top
                if (isValid(temp.x, temp.y + 1) && arr[temp.x][temp.y + 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y + 1] = 2;
                    temp.y++;
                    q.add(new element(temp.x, temp.y));
                    temp.y--;
                }
                // check bottom
                if (isValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
                    if (!flag) {
                        ans++;
                        flag = true;
                    }
                    arr[temp.x][temp.y - 1] = 2;
                    temp.y--;
                    q.add(new element(temp.x, temp.y));
                    temp.y++;
                }

                q.remove();
            }
            q.remove();

            if (!q.isEmpty()) {
                q.add(new element(-1, -1));
            }
        }
        return (checkFresh(arr)) ? -1 : ans;
    }

    public static void main(String[] args) {
        int arr[][] = { { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 } };
        int ans = rotten(arr);
        if (ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }

}
