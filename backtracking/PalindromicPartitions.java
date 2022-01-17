import java.util.ArrayList;

public class PalindromicPartitions {
    static boolean checkPalindrome(String str) {
        int len = str.length();
        len--;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(len))
                return false;
            len--;
        }
        return true;
    }

    // goes through all indexes and recursively add remaining partitions
    // if current string is palindromic
    static ArrayList<ArrayList<String>> addString(ArrayList<ArrayList<String>> v, String s, ArrayList<String> temp,
            int index) {
        int len = s.length();
        String str = "";
        ArrayList<String> curr = new ArrayList<>(temp);
        if (index == 0)
            temp.clear();
        for (int i = index; i < len; i++) {
            str += s.charAt(i);
            if (checkPalindrome(str)) {
                temp.add(str);
                if (i + 1 < len)
                    v = addString(v, s, temp, i + 1);
                // end of string
                else
                    v.add(temp);
                temp = new ArrayList<>(curr);
            }
        }
        return v;
    }

    static void partition(String s, ArrayList<ArrayList<String>> v) {
        ArrayList<String> temp = new ArrayList<>();
        v = addString(v, s, temp, 0);
        printSol(v);
    }

    static void printSol(ArrayList<ArrayList<String>> v) {
        for (ArrayList<String> i : v) {
            for (String j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "geeks";
        ArrayList<ArrayList<String>> partitions = new ArrayList<>();
        partition(s, partitions);
    }
}
