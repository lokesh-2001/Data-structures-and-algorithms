#include<bits/stdc++.h>
using namespace std;

// Method 1 
// using two loops the outer loop picks all elements one by one
// the inner loop looks for the first greater element for element picked by outer loop
// if a greater element is found then that element is printed as next, otherwise -1

void printNGE(int arr[], int n){
    int next;
    for(int i=0;i<n;i++){
        next = -1;
        for(int j= i+1;j<n;j++){
            if(arr[i]<arr[j])
            {
                next = arr[j];
                break;
            } 
        }
        cout<<arr[i]<<"   --  "<<next<<endl;
    }
}
// time complexity O(n^2), auxiliary space - O(1)

// Method 2
// push the first element to the stack
// pick rest of the elements one by one and 
    // mark the current element as next
    // if stack is not empty, compare top element of stack with next
    // if next is greater than top element pop element from the stack
        // next gretater element for the popped element
    // keep popping from the stack while the popped element is smaller than next. next becomes next greater
        // element for all such popped elements
// finally push the next in the stack
// after loop in step 2 is over, pop all the elements from the stack and print -1
    // as the next element for them  

void printNGEI(int arr[],int n){
    stack<int> s;
    s.push(arr[0]);
    for(int i=1;i<n;i++){
        if(s.empty())
        {
            s.push(arr[i]);
            continue;
        }
        while(!s.empty() && s.top() < arr[i] )
        {
            cout<<s.top()<<"  --  "<<arr[i]<<endl;
            s.pop();
        }
        s.push(arr[i]);
    }
    // for the elements not having any greater element print -1
    while(!s.empty()){
        cout<<s.top()<<"  -->  "<<-1<<endl;
        s.pop();
    } 
} 
// Time complexity O(N)
// Auxiliary Space O(N)

// worst case
// all elements are sorted in decreasing order every element processed 4 times
// intially pushed to stack
// popped from stack when next element is being processed
// pushed back to the stack because next element is smaller
// popped from the stack

// Modification - traverse the same in reverse order
void printNGEIi(int arr[],int n){
    stack<int> s;
    int res[n];
    for (int i=n-1;i>=0;i--){
        if(!s.empty()){
            while(!s.empty() && s.top()<=arr[i]){
                s.pop();
            }
        }
        res[i] = s.empty() ? -1 : s.top();
        s.push(arr[i]);
    }
    for(int i=0;i<n;i++)
        cout<<arr[i]<<"  --  "<<res[i]<<endl;
}

int main(){
    int arr[] = {11,9,8,6};
    int n =sizeof(arr)/sizeof(arr[0]);
    // printNGE(arr,n);
    cout<<endl<<endl;
    cout<<"method 2"<<endl;
    printNGEI(arr,n);
    cout<<endl<<endl;
    cout<<"method 2 modification"<<endl;
    printNGEIi(arr,n);
    return 0;
}

