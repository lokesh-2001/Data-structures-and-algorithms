// In a party of N people, only one person is known to everyone. 
// Such a person may be present in the party, if yes, (s)he doesn't 
// know anyone in the party. We can only ask questions like "does A know B? ". 
// Find the stranger (celebrity) in the minimum number of questions.
// We can describe the problem input as an array of numbers/characters representing 
// persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) 
// which returns true if A knows B, false otherwise.

// MATRIX = { {0, 0, 1, 0},
//            {0, 0, 1, 0},
//            {0, 0, 0, 0},
//            {0, 0, 1, 0} }
// Output:id = 2
// Explanation: The person with ID 2 does not 
// know anyone but everyone knows him

public class CelebrityProblem {
    static int N = 8;
    static int matrix[][] = { { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };

    static int knows(int a, int b) {
        return matrix[a][b];
    }

    static int util(int n) {
        if (n == 0)
            return -1;
        int id = findCeleb(n - 1);
        if (id == -1)
            return n - 1;
        else if (knows(id, n - 1) == 1)
            return n - 1;
        else if (knows(n - 1, id) == 1)
            return id;
        return -1;
    }

    static int findCeleb(int n) {
        int id = util(n);
        if (id == -1)
            return id;
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (i != id) {
                c1 += knows(id, i);
                c2 += knows(i, id);
            }
            if (c1 == 0 && c2 == n - 1)
                return id;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int id = findCeleb(n);
        if (id == -1)
            System.out.println("No celebrity");
        else
            System.out.println("Celebrity ID " + id);

    }
}
