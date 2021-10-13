// use dequeue q
// push x in the beginning of q
// pop x from front of q
// top return first element of q
// empty if q empty return true else false
#include<bits/stdc++.h>
using namespace std;
class stackUsingQueue{
    private:
    deque<int> q;
    public:
    void push(int x){
        q.push_front(x);
    }
    int pop(){
        int k = q.front();
        q.pop_front();
        return k;
    }
    int top(){
        return q.front();
    }
    bool empty(){
        if(q.empty())
            return true;
        else
            return false;
    }
};

int main(){
    stackUsingQueue obj;
    obj.push(85);
    // cout<<"Element pushed 1";
    obj.push(96);
    // cout<<"Element pushed 2";
    obj.push(75);
    // cout<<"Element pushed 3";
    obj.push(332);
    // cout<<"Element pushed 4";
    obj.push(742);
    // cout<<"Element pushed 5";
    cout<<obj.pop()<<" popped"<<endl;
    cout<<obj.pop()<<" popped"<<endl;
}


