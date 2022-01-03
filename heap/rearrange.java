import java.util.Comparator;
import java.util.PriorityQueue;
// Rearrange characters in a string such that no two adjacent are same.
public class rearrange {
    static int maxChar = 26;
    static void rearrangeString(String str){
        int n = str.length();
        int[] frequencies = new int[maxChar];
        for(int i = 0;i<n;i++)
            frequencies[str.charAt(i)-'a']++;
        PriorityQueue<Key> q = new PriorityQueue<>(new KeyComparator());
        for(char c = 'a';c<='z';c++){
            int val = c - 'a';
            if(frequencies[val] > 0)
                q.add(new Key(frequencies[val] , c));
        } 
        String result = "";
        Key prev = new Key(-1,'#');
        while(!q.isEmpty()){
            Key k = q.peek();
            q.poll();
            result += k.ch;
            if(prev.freq > 0)
                q.add(prev);
            k.freq --;
            prev = k;
        } 
        if(n!=result.length())
            System.out.println("String Not valid");
        else
            System.out.println("String valid - " + result);
    }
    public static void main(String[] args) {
        rearrangeString("bbbaa");
    }
}
class KeyComparator implements Comparator<Key>{
    public int compare(Key k1, Key k2){
        if(k1.freq < k2.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        return 0;
    }
}
class Key{
    int freq;
    char ch;
    Key(int val, char c){
        freq  = val;
        ch = c;
    }
}
