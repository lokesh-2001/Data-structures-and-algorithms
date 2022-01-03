// Connect "n" ropes with minimum cost
// There are given n ropes of different lengths, we 
// need to connect these ropes into one rope. The 
// cost to connect two ropes is equal to the sum of their lengths.
//  We need to connect the ropes with minimum cost.
public class ConnectNRopes {
    int []harr;
    int size;
    int capacity;
    ConnectNRopes(int a[], int size){
        this.size = size;
        capacity = size;
        harr = a;
        int i = (this.size -1)/2;
        while(i>=0){
            heapify(i);
            i--;
        }
    }
    void heapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < this.size && harr[l] < harr[i])
            smallest = l;
        if (r < this.size && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }
    int extractMin()
    {
        if (this.size <= 0)
            return Integer.MAX_VALUE;
        if (this.size == 1) {
            this.size--;
            return harr[0];
        }
 
        // Store the minimum value, and remove it from heap
        int root = harr[0];
        harr[0] = harr[this.size - 1];
        this.size--;
        heapify(0);
 
        return root;
    }
    void insertKey(int k)
    {
        if (this.size == capacity) {
            System.out.println("Overflow: Could not insertKey");
            return;
        }
        this.size++;
        int i = this.size - 1;
        harr[i] = k;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    boolean isSizeOne()
    {
        return (this.size == 1);
    }
    void swap(int x, int y)
    {
        int temp = harr[x];
        harr[x] = harr[y];
        harr[y] = temp;
    }
    static int minCost(int len[], int n){
        int cost = 0;
        ConnectNRopes h = new ConnectNRopes(len,n);
        while(!h.isSizeOne()){
            int min = h.extractMin();
            int sec_min = h.extractMin();
            cost += (min + sec_min);
            h.insertKey(min + sec_min);
        }
        return cost;
    }
    public static void main(String[] args) {
        int len[] = { 4, 3, 2, 6 };
        int size = len.length;
 
        System.out.println("Total cost for connecting ropes is " + minCost(len, size)); 
    }
}
