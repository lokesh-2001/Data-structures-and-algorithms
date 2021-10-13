// Method 1 
// push all the element to the other stack and pop then and push them back in the
// original stack
#include<bits/stdc++.h>
using namespace std;
class Stack{
    public:
    int top;
    unsigned capacity;
    char * array;
};

// function to create a stack of given capacity
Stack *createStack(unsigned capacity){
    Stack *stack= new Stack();
    stack->capacity = capacity;
    stack->top = -1;
    stack->array = new char[(stack->capacity * sizeof(char))];
    return stack;
}

// check if stack is full top= last index
int isFull(Stack * stack){
    return stack->top == stack->capacity-1;
}
// check if stack is empty top= -1
int isEmpty(Stack * stack){
    return stack->top == -1;
}

// function to add an item to stack
void push(Stack *stack,char item){
    if(isFull(stack))
        return;
    stack->array[++stack->top] = item;
}
// remove an item from stack
char pop(Stack *stack){
    if(isEmpty(stack))
        return -1;
    return stack->array[stack->top --];
}
void reverseI(char str[]){
    int n = strlen(str);
    Stack * stack = createStack(n);
    // Push all characters of string to stack
    int i;
    for(i=0;i<n;i++)
        push(stack,str[i]);
    for(i=0;i<n;i++)
        str[i]= pop(stack);
}
// Complexities
// O(n) time complexity
// O(n) Auxiliary space



// Method 2
// without auxiliary space
void swap(char *a,char *b){
    char temp=*a;
    *a=*b;
    *b=temp;
}
void reverseII(char str[]){
    int n=strlen(str),i;
    for(i=0;i<n/2;i++)
        swap(&str[i],&str[n-1-i]);
}
int main(){
    char str[]="Hello World";
    cout<<"Reversed String Method 1: ";
    reverseI(str);
    cout<<str;
    cout<<endl<<endl;
    cout<<"Reversed String Method 2: ";
    reverseII(str);
    cout<<str;
    cout<<endl<<endl;

}
