// find the middle element of a stack
public class MiddleOfStack {
    class DLL{
        DLL prev;
        int data;
        DLL next;
        DLL(int d){
            data = d;
            next = prev = null;
        }
    }
    class st{
        DLL head;
        DLL mid;
        int count;
    }
    st createSt(){
        st s = new st();
        s.count = 0;
        return s;
    }
    void push(st s, int d){
        DLL node = new DLL(d);
        node.prev = null;
        node.next = s.head;
        s.count+=1;
        if(s.count==1)
            s.mid = node;
        else{
            s.head.prev = node;
            if(s.count%2 !=0)
                s.mid = s.mid.prev;
        }
        s.head = node;
    }
    int pop(st s){
        if(s.count==0){
            System.out.println("Stack Underflow!!");
            return -1;
        }
        DLL head = s.head;
        int d = head.data;
        s.head = head.next;
        if(s.head!=null)
            s.head.prev = null;
        s.count -=1;
        if(s.count % 2 == 0)
            s.mid = s.mid.next;

        return d;
    }
    int findMiddle(st s){
        if(s.count == 0){
            System.out.println("Stack Underflow!!");
            return -1;
        }
        return s.mid.data;
    }
    public static void main(String[] args) {
        MiddleOfStack obj = new MiddleOfStack();
        st ms = obj.createSt();
        obj.push(ms, 11);
        obj.push(ms, 22);
        obj.push(ms, 33);
        obj.push(ms, 44);
        obj.push(ms, 55);
        obj.push(ms, 66);
        obj.push(ms, 77);
 
        System.out.println("Item popped is " + obj.pop(ms));
        System.out.println("Item popped is " + obj.pop(ms));
        System.out.println("Middle Element is "
                           + obj.findMiddle(ms));
    }
}
