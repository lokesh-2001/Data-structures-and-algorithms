// Reverse a String using Stack
public class ReverseAString {
    static class CharStack{
        int size;
        int top;
        char[] arr;
        CharStack(int n){
            size = n;
            top = -1;
            arr = new char[n];
        }
        boolean isEmpty(){
            return top<0;
        }
        boolean push(char x){
            if(top >=size){
                System.out.println("Stack Overflow");
                return false;
            }
            arr[++top] =x;
            return true;
        }
        char pop(){
            if(top<0){
                System.out.println("Stack Underflow");
                return 0;
            }
            char x = arr[top--];
            return x;
        }
    }
    static void reverse(StringBuffer str){
        int n = str.length();
        CharStack chst = new CharStack(n);
        int i;
        for(i=0;i<n;i++)
            chst.push(str.charAt(i));
        for(i = 0;i<n;i++){
            str.setCharAt(i, chst.pop());
        }
    }
    public static void main(String[] args) {
        StringBuffer s= new StringBuffer("Hello World");
        reverse(s);
        System.out.println("Reversed string is " + s);

    }
}
