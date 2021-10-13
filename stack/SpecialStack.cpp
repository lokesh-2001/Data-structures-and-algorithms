// Design a data structure special stack that supports all the stack operations like
// push() pop() isEmpty() isFull() and an additional operations getMin()
// which should return the minumum element from the Specialstack. All the operations of special stack must be
// O(1)  

// solution
// use 2 stacks one to store actual stack elements and the other as an auxiliary stack to store
// minimum values. the idea is to push() and pop() operations in such a way that the top of the auxiliary stack is always the minimum

// Push(int x) inserts an element x to special stack
// 1) push x to the first stack (the stack with actual elements)
// 2) compare x with the top element of the second stack (the auxiliary stack). let the top element by y
//    a) if x is smaller than y then push x to the auxiliary stack 
//    b) if x is greater than y then push y to the auxiliary stack 
// int Pop()  removes an element from special stack and return the removed element
// 1) pop the top element from the auxiliary stack
// 2) pop the top element from the actual stack and return it
// step 1 is necessary to make sure that the auxiliary stack is also updated for future operations
// int getMin() returns the minimum elements from special stack
// 1) return the top element of the auxiliary stack


#include<bits/stdc++.h>
using namespace std;
class Stack{
    private:
        static const int max=100;
        int arr[max];
        int top;
    public: 
        Stack (){top = -1;}
        bool isEmpty();
        bool isFull();
        int pop();
        void push(int x);
};
// Stack method to check if the stack is empty
bool Stack::isEmpty(){
    if(top== -1)
        return true;
    return false;
}
// Stack method to check if the stack is full
bool Stack::isFull(){
    if(top ==  max-1)
        return true;
    return false;
}

// Stack method to remove an element from it
int Stack::pop(){
    if(isEmpty()){
        cout<<"Stack Underflow"<<endl;
        abort();
    }
    int x=arr[top];
    top--;
    return x;
}
// stack method to insert an element to it
void Stack::push(int x){
    if(isFull()){
        cout<<"Stack Overflow";
        abort;
    }
    top++;
    arr[top]=x;
}

// A Special class that supports all the stack operations and one additional
// operation getMin() that returns the minimum element from the stack at any time.
// this class inherits from the stack class and uses an auxiliary stack that holds 
// minimum elements
class SpecialStack : public Stack{
    Stack min;
    public:
    int pop();
    void push(int x);
    int getMin();
};
// Method 1
    // Special Stack member method to insert an element to it .
    // this method makes sure that the min stack is also updated with appropriate
    // minimum values
    // void SpecialStack::push(int x){
    //     if(isEmpty()==true)
    //     {
    //         Stack::push(x);
    //         min.push(x);
    //     }
    //     else{
    //         Stack::push(x);
    //         int y = min.pop();
    //         min.push(y);
    //         if(x<y)
    //             min.push(x);
    //         else
    //             min.push(y);
    //     }
    // }
    // Special Stack member method to remove an element from it. this method removes 
    // top element from min stack also
    // int SpecialStack::pop(){
    //     int x=Stack::pop();
    //     min.pop();
    //     return x;
    // }
    // Special Stack member method to get minimum element from it
    // int SpecialStack::getMin(){
    //     int x=min.pop();
    //     min.push(x);
    //     return x;
    // }

// More Optimized Solution
// the above method can be optimized. we can limit the number of elements
// in auxiliary stack. we can push only when the incoming element of the main stack 
// smaller that or equal to the top of the auxiliary stack
// similarly during pop,  if the pop-off element equal to the top of auxiliary stack
// remove the top element tof the aux. stack, remove the top element of the aux stack

// this method ensures thats the min stack is also updated with app. min value
void SpecialStack::push (int x){
    if(isEmpty()==true)
    {
        Stack::push(x);
        min.push(x);
    }
    else{
        Stack::push(x);
        int y= min.pop();
        min.push(y);
        // push only when incoming element of main stack is smaller that or 
        // equal to top of auxiliary stack
        if(x<=y)
            min.push(x);
    }
}
// this method remove an element from it, it also removes top element from min stack
int SpecialStack::pop(){
    int x= Stack::pop();
    int y=min.pop();
    // push popped element y back only if it is not equal to x
    if(y!=x)
        min.push(y);
    return x;
}

// Auxiliary Space: O(n). 
// The complexity in the worst case is the same as above but in other cases,
//  it will take slightly less space than the above approach as repetition 
//  is neglected.


// Driver program to test Special Stack methods
int main(){
    SpecialStack s;
    s.push(10); 
    s.push(20); 
    s.push(30); 
    cout<<s.getMin()<<endl;
    s.push(5);
    cout<<s.getMin();
    return 0;
}
// time complexity 
// for insert operation O(1)
// for delete operation O(1)
// for getMain operation O(1)
// auxiliary Space O(n)





