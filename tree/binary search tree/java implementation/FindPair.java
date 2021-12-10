// find a pair with given sum in a balanced bst
import java.util.*;
public class FindPair{
    static final int max_size = 100;
    static class node{
        int val;
        node left,right;
    }
    static class Stack{
        int size;
        int top;
        node [] array;
    }
    static Stack createStack(int size){
        Stack stack = new Stack();
        stack.size = size;
        stack.top = -1;
        stack.array = new node[stack.size];
        return stack;
    } 
    static int isFull(Stack stack){
        return (stack.top -1 == stack.size) ? 1 : 0;
    }
    static int isEmpty(Stack stack){
        return stack.top == -1 ? 1 : 0;
    }
    static void push(Stack stack, node root){
        if(isFull(stack) == 1)
            return;
        stack.array[++stack.top] = root;
    }

    static node pop(Stack stack){
        if(isEmpty(stack) == 1)
            return null;
        return stack.array[stack.top--];
    }
    static boolean isPresent(node root, int target){
        Stack s1 = createStack(max_size);
        Stack s2 = createStack(max_size);
     return false;   
    }
}