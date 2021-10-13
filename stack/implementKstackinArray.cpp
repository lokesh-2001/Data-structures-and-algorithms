// The idea is to use two extra arrays for efficient implementation of k 
// stacks in an array. This may not make much sense for integer stacks, but 
// stack items can be large for example stacks of employees, students, etc 
// where every item is of hundreds of bytes. For such large stacks, the extra 
// space used is comparatively very less as we use two integer arrays as extra space.

// Following are the two extra arrays are used:
// 1) top[]: This is of size k and stores indexes of top elements in all stacks.
// 2) next[]: This is of size n and stores indexes of next item for the items in 
// array arr[]. Here arr[] is actual array that stores k stacks.
#include<bits/stdc++.h>
using namespace std;
class kStacks{
        int *arr; // array of size to store actual content to be stored in stacks
        int *top; // array of size k to store indexes of top elements of stack
        int *next; // array of size n to store next entry in all stacks and free list
        int n,k;
        int free1; // to store the beginning index of free list
    public:
        // constructor to create k stack in an array of size n
        kStacks(int k,int n);
        // function to check if space is available
        bool isFull(){return (free1==-1);}
        // to push an item in stack 'sn' sn is from 0 to k-1
        void push(int item, int sn);
        // to pop an item from stack 'sn' sn is from 0 to k-1
        int pop(int sn);
        bool isEmpty(int sn) {return (top[sn]== -1);}
};
kStacks::kStacks(int k1, int n1){
    k=k1;
    n=n1;
    arr = new int[n];
    top = new int[k];
    next = new int[n];
    // initialize all spaces as free
    free1=0;
    for(int i=0;i<n-1;i++)
        next[i] = i+1;
        next[n-1] = -1; // end of free list
}

void kStacks::push(int item, int sn){
    // overflow check
    if(isFull()){
        cout<<"OVERFLOW!!"<<endl;
        return;
    }
    int i = free1; // to store the index of first free slot
    // update index of free slot to index of next slot in free list
    free1 = next[i];
    // update next of top and then top for stack number sn
    next[i] = top[sn];
    top[sn] = i;

    // put the item in array
    arr[i]=item;
}

int kStacks::pop(int sn){
    // underflow
    if(isEmpty(sn)){
        cout<<"UNDERFLOW!!"<<endl;
        return -1;
    }
    // find index of top item in stack number sn
    int i = top[sn];
    top[sn] = next[i];  // change top to store next of previous top
    // attach the previous top to the beginning of free list
    next[i] = free1;
    free1 = i;
    // return the previous top item
    return arr[i];
}

int main()
{
    // Let us create 3 stacks in an array of size 10
    int k = 3, n = 10;
    kStacks ks(k, n);
  
    // Let us put some items in stack number 2
    ks.push(15, 2);
    ks.push(45, 2);
  
    // Let us put some items in stack number 1
    ks.push(17, 1);
    ks.push(49, 1);
    ks.push(39, 1);
  
    // Let us put some items in stack number 0
    ks.push(11, 0);
    ks.push(9, 0);
    ks.push(7, 0);
  
    cout << "Popped element from stack 2 is " << ks.pop(2) << endl;
    cout << "Popped element from stack 1 is " << ks.pop(1) << endl;
    cout << "Popped element from stack 0 is " << ks.pop(0) << endl;
  
    return 0;
}