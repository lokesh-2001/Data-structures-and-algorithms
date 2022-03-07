
// pick the next activity whose finish time is least among the remaining activities and 
// * the start time is more than or equal to the finish time of the previously selected activity
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ActivitySelectionProblem {
    // ? Prints a maximum set of activities that can be done by a single
    // ? person, one at a time.
    // ? n --> Total number of activities
    // ? s[] --> An array that contains start time of all activities
    // ? f[] --> An array that contains finish time of all activities

    // * if the s and f are sorted

    static void solution(int s[], int f[], int n) {
        int i = 0, j;
        System.out.print(i + " ");
        for (j = 1; j < n; j++) {
            if (s[j] > f[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }

    // * if the s and f are not sorted
    // Time Complexity: It takes O(n log n) time if input activities
    // may not be sorted. It takes O(n) time when it is given that input
    // activities are always sorted.

    static void solution2(Activity arr[], int n) {
        Compare obj = new Compare();
        obj.compare(arr, n);
        int i = 0;
        System.out.print("(" + arr[i].start + "," + arr[i].finish + ")  ");

        for (int j = 1; j < n; j++) {
            if (arr[j].finish >= arr[i].finish) {
                System.out.print("(" + arr[j].start + "," + arr[j].finish + ")  ");
                i = j;
            }
        }
    }

    // * same method bt using stl
    static void solution3(int s[], int f[]) {
        ArrayList<Activity> ans = new ArrayList<>();
        PriorityQueue<Activity> q = new PriorityQueue<>(
                (q1, q2) -> q1.finish - q2.finish);

        for (int i = 0; i < s.length; i++)
            q.add(new Activity(s[i], f[i]));
        Activity it = q.poll();
        int st = it.start;
        int en = it.finish;
        ans.add(new Activity(st, en));

        while (!q.isEmpty()) {
            Activity itr = q.poll();
            if (itr.start >= en) {
                st = itr.start;
                en = itr.finish;
                ans.add(new Activity(st, en));
            }
        }

        for (Activity itr : ans) 
            System.out.println(
                    "Activity started at: " + itr.start + " and ends at  " + itr.finish);
        
    }

    public static void main(String[] args) {
        // solution 1
        int s[] = { 1, 3, 0, 5, 8, 5 };
        int f[] = { 2, 4, 6, 7, 9, 9 };
        solution(s, f, s.length);
        
        System.out.println();
        System.out.println();
        
        // solution 2

        int n = 6;
        Activity arr[] = new Activity[n];
        arr[0] = new Activity(5, 9);
        arr[1] = new Activity(1, 2);
        arr[2] = new Activity(3, 4);
        arr[3] = new Activity(0, 6);
        arr[4] = new Activity(5, 7);
        arr[5] = new Activity(8, 9);

        solution2(arr, n);

        System.out.println();
        System.out.println();
        
        // solution 3

        solution3(s, f);
    }
}

class Activity {
    int start, finish;

    Activity(int st, int fi) {
        start = st;
        finish = fi;
    }
}

class Compare {
    void compare(Activity arr[], int n) {
        Arrays.sort(arr, new Comparator<Activity>() {
            public int compare(Activity s1, Activity s2) {
                return s1.finish - s2.finish;
            }
        });
    }
}