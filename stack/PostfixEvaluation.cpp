// to evaluate a postfix expression
// method 1
// 1> create a stack to store operands (or values)
// 2> scan the given expression and do the following for every scanned element
//      a> if the element is number push it into the stack
//      b> if the element is operator, pop operands for the operator from stack
// Evaluate the operator and push the result back to the stack
// 3> when the expression is needed, the number in the stack is the final answer

#include <bits/stdc++.h>
using namespace std;

class Stack{
    public:
    int top;
    unsigned capacity;
    int *array;
};
// creation of stack
Stack* createStack(unsigned capacity){
    Stack *stack = new Stack();
    if(!stack) return NULL;
    stack->top = -1;
    stack->capacity = capacity;
    stack->array = new int[(stack->capacity) * sizeof(int)];
    if(!stack->array)  return NULL;
    return stack;
}
int isEmpty(Stack* stack){
    return stack->top == -1;
}

int peek(Stack *stack){
    return stack->array[stack->top];
}
int pop(Stack* stack){
    if(!isEmpty(stack))
        return stack->array[stack->top--];
    return '$';
}

void push(Stack* stack,int op)
{    stack->array[++stack -> top] = op;
}
int evaluatePostfix(char *exp){
    // create a stack of capacity equal to expression size
    Stack * stack= createStack(strlen(exp));
    int i;
    // check if stack created
    if(!stack) return -1;
    
    // scan characters
    for(i=0;exp[i];++i){
        // if character is blank continue
        if(exp[i] == ' ')   continue;

        // if scanned character is a number extract the full no
        // push it to the stack
        else if(isdigit(exp[i])){
            int num=0;
            // extract full number
            while(isdigit(exp[i]))
            {
                num=num*10 + int(exp[i]- '0');
                i++;
            }
            i--;
            // push the element is stack
            push(stack,num);
        }
        // scanned character is an operator pop two elements from
        // stack and then apply the operator
        else{
            int val1=pop(stack);
            int val2=pop(stack);
            switch(exp[i]){
                case '+':push(stack, val2 + val1); break;
                case '-':push(stack, val2 - val1); break;
                case '*':push(stack, val2 * val1); break;
                case '/':push(stack, val2 / val1); break;
            }
        }

    } 
    return pop(stack);
} 
int main()
{
    char exp[] = "100 200 + 2 / 5 * 7 +";
    cout << evaluatePostfix(exp);
    return 0;
}
 