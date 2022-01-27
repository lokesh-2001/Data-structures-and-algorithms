public class stack{
    private int arr[];
    private int top;
    private int capacity;
    stack(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    public void push(int x){
        if(isFull()){
            System.out.println("Stack Overflow!!");
            return;
        }
        System.out.println("Inserting : " + x );
        arr[++top] = x;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow!!");
            return -1;
        }
        System.out.println("Removing : " + peek());
        return arr[top--];
    }
    public int peek(){
        if(!isEmpty())
            return arr[top];
        return -1;
    }
    public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top == capacity-1;
    }
}