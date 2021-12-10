import java.util.ArrayList;
class Heap{
    void swap(ArrayList<Integer> a,int x, int y){
        int temp = a.get(x);
        a.set(x, a.get(y));
        a.set(y,temp);

    }
    void heapify(ArrayList<Integer> a,int n, int i){
        n = a.size();
        int largest  = i;
        int left  = 2*i+1;
        int right  = 2*i+2;
        if(left<n && a.get(left) > a.get(largest)){
            largest = left;
        }
        if(right<n && a.get(right) > a.get(largest)){
            largest = right;
        }
        if(largest!=i){
            swap(a,largest,i);
            heapify(a, n,largest);
        }
    }
    void insert(ArrayList<Integer> a, int n,int value){
        n = a.size();
        if(n==0)
            a.add(value);
        else{
            a.add(value);
            for(int i=n/2-1; i>=0; i--)
                heapify(a,n,i);
        }
    }
    void delete(ArrayList<Integer> a, int n ,int num){
        n = a.size();
        int i;
        for(i = 0 ;i <n;i++)
            if(num == a.get(i))
                break;
        swap(a,i,n-1);
        a.remove(n-1);
        for(int j=n/2-1; j>=0; j--)
           heapify(a,n,j);
    }
    void print(ArrayList<Integer> a, int n){
        n  = a.size();
        for(Integer i : a)
            System.out.println(i + " ");
        System.out.println();
    }
}
public class MaxHeap{
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        Heap h = new Heap();
        int n = a.size();
        h.insert(a,n,3); 
        h.insert(a,n,4); 
        h.insert(a,n,9); 
        h.insert(a,n,5); 
        h.insert(a,n,2); 
        
        // h.insert(a,7); 
        // h.insert(a,74); 
        // h.insert(a,12); 
        // h.insert(a,36); 
        // h.insert(a,87); 
        // h.insert(a,96); 
        // h.insert(a,24); 
        // h.insert(a,63); 
        System.out.println("Max heap Array: ");
        h.print(a,n);
        h.delete(a, n,4);
        System.out.println("Max heap Array after deletion: ");
        h.print(a,n);

    }

}