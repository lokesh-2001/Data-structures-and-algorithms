import java.util.Comparator;
import java.util.PriorityQueue;
class HuffmanNode{
    int data;
    char c;
    HuffmanNode left,right;
}
class Mycom implements Comparator<HuffmanNode>{
    public int compare(HuffmanNode x, HuffmanNode y){
        return x.data - y.data;
    }
}
public class HuffmanCoding {
    static void printCode(HuffmanNode root, String s){
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            System.out.println(root.c + " : " + s);
            return;
        }
        // if we go to left then add "0" to the code.
        // if we go to the right add"1" to the code.
        printCode(root.left, s+"0");
        printCode(root.right, s+"1");
    }
    static void createHuffman(int n, char[] chrArray, int [] charFreq){
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(n, new Mycom());
        for(int i=0;i<n;i++){
            HuffmanNode hn = new HuffmanNode();
            hn.c = chrArray[i];
            hn.data = charFreq[i];
            hn.left = null;
            hn.right = null;
            pq.add(hn);
        } 
        HuffmanNode root = null;
        while(pq.size() > 1){
            HuffmanNode x = pq.poll();
            HuffmanNode y = pq.poll();
            HuffmanNode f = new HuffmanNode();
            f.data = x.data+y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;
            pq.add(f);
        }
        printCode(root,"");

    }
    public static void main(String[] args) {
        int n = 6;
        String str = "abcdef";
        char chrArray[] = str.toCharArray();
        int [] charFreq = {5,9,12,13,16,45};
        createHuffman(n, chrArray, charFreq);
    }
}
