// create a data structure that represents k queues in one single array
// solution
// use 3 arrays
// front 
// rear
// next
// the arr[] is actual array that stores k stacks
// together with k queues a stack of free slots in arr[] is also stored
// and top of this stack is stored in a variable free
#include<bits/stdc++.h>
using namespace std;

class kQueues{
    int *arr;
    int *front;
    int *rear;
    int *next;
    int n,k;
    int free1;
    public:
    kQueues(int k,int n);
    bool isFull(){return free1 == -1;}
    void enqueue(int item,int qn);
    int dequeue(int qn);
    bool isEmpty(int qn){return front[qn] == -1;}
};

kQueues::kQueues(int k1 , int n1){
    k= k1;
    n=n1;
    arr = new int[n];
    front = new int[k];
    rear = new int[k];
    next = new int[k];
    for(int i=0;i<k;i++)
        front[i] = -1;
    free1=0;
    for(int i=0;i<n-1;i++)
        next[i] = i+1;
    next[n-1] = -1; 
}
void kQueues::enqueue(int item , int qn){
    if(isFull())
    {
        cout<<"OverFlow!!";
        return;
    }
    int i= free1;
    free1 = next[i];
    if(isEmpty(qn))
        front[qn] = i;
    else
        next[rear[qn]] = i;
    next[i] = -1;
    rear[qn] = i;
    arr[i] = item;        
}
int kQueues::dequeue(int qn){
    if(isEmpty(qn))
    {
        cout<<"UnderFlow!!";
        return -1;
    }
    int i = front[qn];
    front[qn] = next[i];  // change top to store next of previous top
    next[i] = free1;
    free1 = i;
    return arr[i]; 
}
int main()
{
    // Let us create 3 queue in an array of size 10
    int k = 3, n = 10;
    kQueues ks(k, n);
 
    // Let us put some items in queue number 2
    ks.enqueue(15, 2);
    ks.enqueue(45, 2);
 
    // Let us put some items in queue number 1
    ks.enqueue(17, 1);
    ks.enqueue(49, 1);
    ks.enqueue(39, 1);
 
    // Let us put some items in queue number 0
    ks.enqueue(11, 0);
    ks.enqueue(9, 0);
    ks.enqueue(7, 0);
 
    cout << "Dequeued element from queue 2 is " << ks.dequeue(2) << endl;
    cout << "Dequeued element from queue 1 is " << ks.dequeue(1) << endl;
    cout << "Dequeued element from queue 0 is " << ks.dequeue(0) << endl;
 
    return 0;
}


