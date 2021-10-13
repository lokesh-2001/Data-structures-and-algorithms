//infix to postfix conversion
// Algorithm
// 1> Scan the infix expression from left to right
// 2> if the scanned character is an operand output it
// 3> else
//      a> if the precedence of the scanned operator is greater than that of
//      the operator in stack (or the stack is empty or contains a '(' ), push it
//      b> else, pop all the operators from the stack which are greater than or equal to in 
//      precedence than that of the scanned operator. after doing the push the scanned operator
//      to the stack (if you encounter paranthesis while popping then stop there and push the scanned 
//      operator in the stack)
// 4> if the scanned character is an '(' push it to the stack
// 5> if the scanned character is an ')' pop the stack and output it until a '(' is encountered 
//  and discard both the paranthesis
// 6> repeat 2-6 until infix expression is scanned
// 7> print the output
// 8> pop and output from the stack until its not empty
#include<bits/stdc++.h>
using namespace std;

// function to return the precedence of the operator
int prec(char c)
{
    if(c=='^')
        return 3;
    else if(c=='/' || c=='*')
        return 2;
    else if(c=='+' || c=='-')
        return 1;
    return -1;
}

// conversion function for infix to postfix
void InfixToPostfix(string s){
    stack<char> st;
    string result;
    for (int i=0;i<s.length();i++)
    {
        char c =s[i];
        
        // if the scanned character is an operand add it to the output string  
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
            result+=c;
        // if the scanned character is '(' push it to the stack
        else if(c=='(')
            st.push('(');
        // if the scanned character is an ')' pop and to output string from the 
        // stack until an '(' is encountered
        else if(c==')'){
            while(st.top()!='(')
            {
                result+=st.top();
                st.pop();
            }
            st.pop();
        }
        // if an operator is scanned
        else{
            while(!st.empty()&& prec(s[i]) <= prec(st.top()) ){
                result+=st.top();
                st.pop();
            }
            st.push(c);
        }
    }
    while(!st.empty()){
        result+=st.top();
        st.pop();
    }
    cout<<result<<endl;
}
int main(){
    string ep= "a+b*(c^d-e)^(f+g8h)-i";
    InfixToPostfix(ep);
    return 0;
}



