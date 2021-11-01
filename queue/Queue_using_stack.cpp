#include<bits/stdc++.h>
using namespace std;
// using single stack
// for push in queue simply push it in stack
// for pop use recursion 
// pop one element in stack and keep base condition after that
// base condition: if stack is empty we know that the last popped value
    // is the last value in the stack. and the last value in the stack is front
    // of queue so only then return the value without pushing it back to stack
// otherwise recursively call pop function again, store the value of it in another variable
    // and after that push the popped out value for that calling in stack
    // by this recursion will totally end and values will be pushed in the order they were popped out
    // just deleting the last value in the stack

// https://prepinsta.com/cpp-program/implementation-of-queue-using-one-stack/

class newQueue{
    public:
    stack<int> s;
    int size;
    newQueue() {size = 0;}
    void Queuepush(int x){
        cout<<x<<" is pushed to queue"<<endl;
        s.push(x);
        size ++;
    }

    int QueuePop(){
        if(size==0){
            cout<<"Queue Empty!!"<<endl;
            return;
        }
        int a = s.top();
        s.pop();
    return a;
    }
};
