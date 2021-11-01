#include<bits/stdc++.h>
using namespace std;
void reverse(queue<int>& q1){
    stack<int> s;
    while(!q1.empty())
    {
        s.push(q1.front());
        q1.pop();
    }
    while(!s.empty()){
        q1.push(s.top());
        s.pop();
    }
}   
void printQueue(queue<int> q1){
    while(!q1.empty()){
        cout<<q1.front()<<" ";
        q1.pop();
    }
}
int main(){
    queue<int> q1;
    q1.push(85);
    q1.push(96);
    q1.push(52);
    q1.push(41);
    q1.push(30);
    q1.push(70);
    q1.push(90);
    cout<<"Before Reversing: "<<endl<<"85 96 52 41 30 70 90"<<endl;
    cout<<"After Reversing: "<<endl;
    reverse(q1);
    printQueue(q1);
}