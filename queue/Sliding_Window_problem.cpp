// Sliding window maximum
// maximum of all subarrays of size k
#include<bits/stdc++.h>
using namespace std;
// method 1 
// using 2 loops

void printKMax1(int a[],int n , int k){
    int max;
    for(int i=0;i<=n-k;i++){
        max= a[i];
        for(int j=1;j<k;j++){
            if(a[i+j] > max)
                max = a[i+j];
        }
        cout<<max<<" ";
    }
}

// method 2 using dequeue
// run a loop and insert first k elements in the dequeue
    // before inseting the element check if the element at the back of queue
    // is smaller than the current element if it is so remove the element from 
    // the back of the deque until all the elements in left in deque are greater than the
    // current element then insert the current element at the back of the deque
// now run a loop from k to end of the array
// print the front elements of the deque
// remove the element from the front of the queue if they are out of current window
// insert the next element in the deque. before inserting the element, check if the element
    // at the back of the queue is smaller than the current element, if it is so
    // remove from the back of the deque until all elements left in the deque
    // are greater than the current element, at the back of the deque
// print the max element of the last window


void printKMax2(int arr[],int n , int k){
    // create a deque qi that will store the indexes of array element
    // the queue will store indexes of useful elements in every window and it will
    // maintain decreasing order of values from front to rear in Qi i.e.
    // arr[Qi.front()] to arr[Qi.rear()] are sorted in decreasing order
    std::deque<int>Qi(k);
    // process first k elements
    int i;
    for(i=0;i<k;i++){
        // for every element the previous smaller element are useless
        // so remove from dequeue
        while((!Qi.empty())&& arr[i]>=arr[Qi.back()])
            Qi.pop_back();
        Qi.push_back(i);
    }
    // process rest of elements i.e. from arr[k] to arr[n-1]
    for(;i<n;++i){
        // the element at the front of the queue is largest element of the previous window
        // so print it
        cout<<arr[Qi.front()]<<" ";
        // remove the elements which are out of this window
        while((!Qi.empty()) && Qi.front()<=i-k)
            Qi.pop_front();
    }   


}



int main(){
    int arr[] = {85,41,263,74,96,745,25,36,2,0,42};
    int n= sizeof(arr)/sizeof(arr[0]);
    int k=3;
    printKMax1(arr,n,k);
    return 0;
}

