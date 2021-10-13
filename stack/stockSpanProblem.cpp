#include<bits/stdc++.h>
using namespace std;

// Method 1
// traverse the input price array. for each element being visited traverse 
// elements on the left of it and increment the span value of it while elements on the left side
// are smaller 

void calculateSpanI(int price[],int n,int s[]){
    s[0]=1;
    for(int i=1;i<n;i++)
    {
        s[i]=1;
        for(int j=i-1;(j >=0) && (price[i]>=price[j]);j--)
            s[i]++;
    }
}
// The Time Complexity of the above method is O(n^2).

// Method 2
// We see that S[i] on the day i can be easily computed if we know the closest day 
// preceding i, such that the price is greater than on that day than the price on 
// the day i. If such a day exists, let’s call it h(i), otherwise, we define h(i) = -1. 
// The span is now computed as S[i] = i – h(i)

// we use a stack as an abstract data type to store the days i, h(i), h(h(i)), and so on. 
// When we go from day i-1 to i, we pop the days when the price of the stock was less than 
// or equal to price[i] and then push the value of day i back into the stack.
// every element of the array is added and removed from the stack art most once
// so that there are total 2n operations at most

void calculateSpanII(int price[],int n,int s[]){
    // create a stack and push index of first element to it
    stack<int> st;
    st.push(0);
    s[0]=1;
    // calculate span values for rest of elements
    for(int i=0;i<n;i++){
        // pop elements from stack while stack is not empty and top
        // of the stack is smaller than price[i]
        while(!st.empty() && price[st.top()]<=price[i])
            st.pop();
        // if stack becomes empty then price[i] is greater than all elemets
        // on left of it else price[i] is greater than elements after top of stack
        s[i]= (st.empty()) ? i+1 : i-st.top();

        st.push(i);
    }
}

// Method 3 
// same as method 2 bt without stack
void calculateSpanIII(int price[],int n, int s[]){
    s[0]=1;
    for (int i=1;i<n;i++){
        int counter =1;
        while((i-counter)>=0 && price[i]>= price[i-counter])
            counter+= price[i-counter];
        
    price[i]=counter;
    }
}


void printArray(int arr[],int n){
    for (int i=0;i<n;i++)
        cout<<arr[i]<<" ";
}

int main(){
    int price[] = {10,4,5,90,120,80};
    int n = sizeof(price)/sizeof(price[0]);
    int sI[n],sII[n],sIII[n];
    calculateSpanI(price,n,sI);
    calculateSpanII(price,n,sII);
    calculateSpanII(price,n,sIII);
    printArray(sI,n);
    cout<<endl;
    printArray(sII,n);
    cout<<endl;
    printArray(sIII,n);
    return 0;
}

