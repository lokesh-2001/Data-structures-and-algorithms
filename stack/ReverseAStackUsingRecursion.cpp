// The idea of the solution is to hold all values in Function Call 
// Stack until the stack becomes empty. When the stack becomes empty, 
// insert all held items one by one at the bottom of the stack. 

// 2 functions one to insert an element at bottom of stack and other reverse
// insertAtBottom: first pop all stack elements and store the popped item in function
// call stack using recursion and when stack becomes empty push new item and all items
// stored in call stack
// reverse: this fun uses the above function to pop all elements one by one and insert the popped items
// at bottom

#include<bits/stdc++.h>
using namespace std;
stack<char> st;
 
string ns;
 
// Below is a recursive function that inserts an element at the bottom of a stack.
char insert_at_bottom(char x)
{
 
    if(st.size() == 0)
    st.push(x);
 
    else
    {
         
        char a = st.top();
        st.pop();
        insert_at_bottom(x);
        st.push(a);
    }
}
char reverse()
{
    if(st.size()>0)
    {
        char x = st.top();
        st.pop();
        reverse();
        insert_at_bottom(x);
    }
}
 
// Driver Code
int main()
{
     
    // push elements into
    // the stack
    st.push('1');
    st.push('2');
    st.push('3');
    st.push('4');
     
    cout<<"Original Stack"<<endl;
     
    // print the elements
    // of original stack
    cout<<"1"<<" "<<"2"<<" "
        <<"3"<<" "<<"4"
        <<endl;
     
    // function to reverse
    // the stack
    reverse();
    cout<<"Reversed Stack"
        <<endl;
     
    // storing values of reversed
    // stack into a string for display
    while(!st.empty())
    {
        char p=st.top();
        st.pop();
        ns+=p;
    }
     
    //display of reversed stack
    cout<<ns[3]<<" "<<ns[2]<<" "
        <<ns[1]<<" "<<ns[0]<<endl;
    return 0;
}

// time complexity O(n^2)