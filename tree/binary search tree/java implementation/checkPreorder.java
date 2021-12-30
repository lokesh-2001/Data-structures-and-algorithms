// check preorder is valid or not
// Given an array of numbers, return true if given array can represent preorder traversal of a Binary Search Tree, else return false.
public class checkPreorder {
    static int preIndex = 0;
    static void util(int n, int[] pre, int min, int max){
        if(preIndex >= n)
            return;
        if(min<=pre[preIndex] && pre[preIndex] <=max){
            int d = pre[preIndex];
            preIndex++;
            util(n, pre, min,d);
            util(n, pre, d,max);
        }
    }
    static boolean check(int[] arr, int n){
        util(n, arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return preIndex == n;
    }
    public static void main(String[] args) {
        int[] preorder1 = { 2, 4, 3 };
        int n1 = preorder1.length;
        System.out.println();
        if (check(preorder1, n1))
            System.out.print("preorder1 can represent BST");
        else
            System.out.print("preorder1 can not represent BST  :(");

        int[] preorder2 = { 5, 3, 4, 1, 6, 10 };
        int n2 = preorder2.length;
        System.out.println();
        if (check(preorder2, n2))
            System.out.print("preorder2 can represent BST");
        else
            System.out.print("preorder2 can not represent BST  :(");

        int[] preorder3 = { 5, 3, 4, 8, 6, 10 };
        int n3 = preorder3.length;
        System.out.println();
        if (check(preorder3, n3))
            System.out.print("preorder3 can represent BST");
        else
            System.out.print("preorder3 can not represent BST  :(");
           
    }
}
