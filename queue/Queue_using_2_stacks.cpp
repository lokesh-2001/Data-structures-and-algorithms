#include <bits/stdc++.h>
using namespace std;
// Queue using 2 stacks

// method 1
// making enqueue costly
// basically pop the top of stack to remove the element from queue
// and for push operation firstly push all elements from st1 to st2 
// st1 will be empty then push the new element from st2 to st1 
struct newQueue1{
    stack<int> s1,s2;
    int dequeue1(){
        int temp;
        temp=s1.top();
        s1.pop();
        return temp;
    }
    void enqueue1(int x){
        while(!s1.empty())
        {
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
};

// method 1
// making dequeue costly
// basically push at the top of stack to add the element in queue
// and for pop operation firstly push all elements from st1 to st2 
// st1 will be empty then pop the element from st2 and return 
struct newQueue2{
    stack<int> s1,s2;
    void enqueue2(int x){
        s1.push(x);
    }
    int dequeue2(){
        while(!s1.empty())
        {
            s2.push(s1.top());
            s1.pop();
        }
        int temp = s2.top();
        s2.pop();
        while(!s2.empty())
        {
            s1.push(s2.top());
            s2.pop();
        }
        return temp;
    }
};

int main(){
    cout<<"Method 1"<<endl;
    newQueue1 q1;
    q1.enqueue1(34);
    q1.enqueue1(74);
    q1.enqueue1(98);
    q1.enqueue1(20);
    q1.enqueue1(36);
    cout<<q1.dequeue1()<<endl;
    cout<<q1.dequeue1()<<endl;
    cout<<q1.dequeue1()<<endl;

    cout<<endl<<endl<<"Method 2"<<endl;
    newQueue2 q2;
    q2.enqueue2(75);
    q2.enqueue2(20);
    q2.enqueue2(69);
    q2.enqueue2(41);
    q2.enqueue2(23);
    cout<<q2.dequeue2()<<endl;
    cout<<q2.dequeue2()<<endl;
    cout<<q2.dequeue2()<<endl;

}
