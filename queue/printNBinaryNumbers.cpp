#include<bits/stdc++.h>
using namespace std;

// method
// create an empty queue of strings
// enqueue the first binary number "1" to enqueue
// now run a loop for generating and printing n binary numbers
    // dequeue and print the front of queue
    // append "0" to the end of front item and enqueue it
    // append "1" to the end of front item and enqueue it

void binaryNumbers(int n){
    queue<string> q;
    q.push("1");
    while(n--){
        string s1 = q.front();
        q.pop();
        cout<<s1<<" ";
        string s2 =s1;
        q.push(s1.append("0"));
        q.push(s2.append("1"));
    }
}
int main(){
    int n=10;
    binaryNumbers(n);
    return 0;
}

