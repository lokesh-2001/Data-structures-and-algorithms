// Smallest range in "K" Lists
public class smallestRange {
    static class Node{
        int data;
        int i; // index of the list from which the element is taken
        int j;// index of the next element to be picked from list
        Node (int a, int b, int c){
            data = a;
            i = b;
            j = c;
        }
    }
    static class MinHeap{
        Node []harr;
        int size;
        MinHeap(Node[] arr, int size){
            this.harr = arr;
            this.size = size;
            int i = (size-1)/2;
            while(i>=0){
                heapify(i);
                i--;
            }
        }
        int left(int i){
            return 2*i+1;
        }
        int right(int i){
            return 2*i+2;
        }
        void heapify(int i){
            int l = left(i);
            int r = right(i);
            int small = i;
            if (l < size && harr[l].data < harr[i].data)
                small = l;
            if (r < size && harr[r].data < harr[small].data)
                small = r;
            if (small != i) {
                swap(small, i);
                heapify(small);
            }  
        }
        void swap(int x, int y){
            Node temp = harr[x];
            harr[x] = harr[y];
            harr[y] = temp;
        }
        Node getMin(){
            return harr[0];
        }
        void replaceMin(Node x){
            harr[0] = x;
            heapify(0);
        }
    }
    static void findRange(int[][] arr, int k){
        int range =Integer.MAX_VALUE,
        min =Integer.MAX_VALUE,
        max =Integer.MIN_VALUE;
        int start = -1,end = -1;
        int n = arr[0].length;
        Node[] arr1 = new Node[k];
        for(int i=0;i<k;i++){
            Node node = new Node(arr[i][0],i,1);
            arr1[i] = node;
            max = Math.max(max, node.data);
        }
        MinHeap mh = new MinHeap(arr1,k);
        while(true){
            Node root = mh.getMin();
            min = root.data;
            if(range > max - min + 1){
                range = max - min + 1;
                start = min;
                end = max;
            }
            if(root.j < n){
                root.data = arr[root.i][root.j];
                root.j++;
                if(root.data > max)
                    max = root.data;
            }
            else
                break;

            mh.replaceMin(root);
        }
        System.out.println("Smallest Range: [ " + start + " , " + end + " ]");
    } 
    public static void main(String[] args) {
        int arr[][] = { { 4, 7, 9, 12, 15 },
                        { 0, 8, 10, 14, 20 },
                        { 6, 12, 16, 30, 50 } };
  
        int k = arr.length;
  
        findRange(arr, k);
    }
}
