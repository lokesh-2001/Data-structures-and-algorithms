// Implementing Queue Using stack
// A queue can be implemented using 2 stacks. 

// Method 1
// By making enqueue operation costly
// this method makes sure that the oldest entered element is always at the top of the stack1 
// so that the deQueue operation just pops from stack 1 to put the element at top of stack1, stack 2 is used
// Algorithm
    // enQueue(q,x):
    // while stack 1 is not empty push everythin from stack 1 to stack 2
    // push x to stack (Assuming size of stacks is unlimited)
    // push everything back to stack 1
    // Time Complexity is O(n)
    // deQueue(q):
    // if stack 1 is empty then error
    // pop an item from stack 1 and return it
    // Here time complexity will be O(1)

#include<bits/stdc++.h>
using namespace std;
class Queue
{
public:
    stack<int> s1,s2;
    void enQueue(int x){
        while(!s1.empty()){
            s2.push(s1.top());
            s1.pop();
        }
        s1.push(x);

        while(!s2.empty())
        {
            s1.push(s2.top());
            s2.pop();
        }
    }
int dequeue(){
    if(s1.empty())
    {
        cout<<"Queue empty";
        exit(0);
    }
    // return top of s1
    int x= s1.top();
    s1.pop();
    return x;
    
    }
};
int main(){
    Queue q;
    q.enQueue(1);
    q.enQueue(2);
    q.enQueue(3);
    q.enQueue(4);
    cout<<q.dequeue()<<endl;
    cout<<q.dequeue()<<endl;
    cout<<q.dequeue()<<endl;

return 0;
}
